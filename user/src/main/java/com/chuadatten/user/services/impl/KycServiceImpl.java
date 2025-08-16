package com.chuadatten.user.services.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.chuadatten.user.dto.UserVerificationDto;
import com.chuadatten.user.entity.UserInf;
import com.chuadatten.user.entity.UserVerification;
import com.chuadatten.user.exceptions.CustomException;
import com.chuadatten.user.exceptions.ErrorCode;
import com.chuadatten.user.file.FileStorageService;
import com.chuadatten.user.mapper.UserKycMapper;
import com.chuadatten.user.repository.UserInfRepository;
import com.chuadatten.user.repository.UserVerificationRepository;
import com.chuadatten.user.requests.UserVerificationRequest;
import com.chuadatten.user.responses.ApiResponse;
import com.chuadatten.user.services.KycService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KycServiceImpl implements KycService {
    private final UserVerificationRepository userVerificationRepository;
    private final UserKycMapper userKycMapper;
    private final FileStorageService fileStorageService;
    private final UserInfRepository userInfRepository;

    @Override
    public ApiResponse<UserVerificationDto> getVerificationRequest(UUID id) {
        return ApiResponse.<UserVerificationDto>builder()
                .data(userKycMapper.toDto(userVerificationRepository.findById(id).orElseThrow(
                        () -> new CustomException(ErrorCode.VERIFICATION_NOT_EXIST))))
                .build();
    }

    @Override
    public ApiResponse<UserVerificationDto> submitVerificationRequest(
            UserVerificationRequest userVerificationRequest,
            UUID userId) {
        String docBack = fileStorageService.storeFile(userVerificationRequest.getDocumentBackUrl(), "kyc", userId.toString());
        String docFront = fileStorageService.storeFile(userVerificationRequest.getDocumentFrontUrl(), "kyc", userId.toString());
        String docSelfie = fileStorageService.storeFile(userVerificationRequest.getFaceIdFrontUrl(), "kyc", userId.toString());

        UserInf u = userInfRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        Optional<UserVerification> lastestVersionOpt = userVerificationRepository
                .findTopByUserIdOrderByVersionDesc(userId);

        UserVerification newVerification = UserVerification.builder()
        .documentBackUrl(docBack)
        .documentFrontUrl(docFront)
        .faceIdFrontUrl(docSelfie)
        .user(u)
        .build();

        lastestVersionOpt.ifPresentOrElse(
                ver -> newVerification.setVersion(ver.getVersion() + 1),
                () -> newVerification.setVersion(1));

        userVerificationRepository.save(newVerification);

        return ApiResponse.<UserVerificationDto>builder()
                .data(userKycMapper.toDto(newVerification))
                .build();
    }

}
