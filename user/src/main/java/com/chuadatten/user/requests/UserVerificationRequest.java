package com.chuadatten.user.requests;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserVerificationRequest {
    private MultipartFile faceIdFrontUrl;
    private MultipartFile documentFrontUrl;
    private MultipartFile documentBackUrl;
}
