package com.chuadatten.wallet.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.chuadatten.wallet.exceptions.CustomException;
import com.chuadatten.wallet.exceptions.ErrorCode;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path rootLocation;
    private final String baseUrl;

    public FileStorageService(
            @Value("${file.upload-dir}") String uploadDir,
            @Value("${file.base-url}") String baseUrl) {

        this.rootLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
        this.baseUrl = baseUrl;

        try {
            Files.createDirectories(this.rootLocation);
        } catch (IOException ex) {
            throw new CustomException(ErrorCode.CREATE_DIRECTORY_FAILED);
        }
    }

    /**
     * Lưu file vào thư mục con và trả về URL công khai
     */
    public String storeFile(MultipartFile file, String folder, String id) {
        validateFile(file);
        String originalName = StringUtils.cleanPath(Objects.requireNonNullElse(file.getOriginalFilename(), ""));
        String ext = getFileExtension(originalName);
        String fileName = UUID.randomUUID() + (ext.isEmpty() ? "" : "." + ext);

        try {
            Path targetDir = this.rootLocation.resolve(Paths.get(folder, id)).normalize();
            Files.createDirectories(targetDir);

            Path targetFile = targetDir.resolve(fileName);
            Files.copy(file.getInputStream(), targetFile, StandardCopyOption.REPLACE_EXISTING);

            return String.format("%s/%s/%s/%s", baseUrl, folder, id, fileName);

        } catch (IOException ex) {
            throw new CustomException(ErrorCode.FILE_UPLOAD_FAILED);
        }
    }

    /**
     * Lấy file làm Resource
     */
    public Resource loadFileAsResource(String folder, String id, String fileName) {
        try {
            Path filePath = rootLocation.resolve(Paths.get(folder, id, fileName)).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new CustomException(ErrorCode.FILE_NOT_FOUND);
            }
        } catch (MalformedURLException ex) {
            throw new CustomException(ErrorCode.CANT_READ_FILE);
        }
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new CustomException(ErrorCode.FILE_EMPTY);
        }
        if (file.getSize() > 5 * 1024 * 1024) { // 5MB
            throw new CustomException(ErrorCode.FILE_TOO_BIG);
        }
    }

    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf(".");
        return (lastIndex > 0) ? fileName.substring(lastIndex + 1) : "";
    }
}
