package com.chuadatten.user.controller;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuadatten.user.anotation.JwtClaims;
import com.chuadatten.user.dto.UserVerificationDto;
import com.chuadatten.user.requests.UserVerificationRequest;
import com.chuadatten.user.responses.ApiResponse;
import com.chuadatten.user.services.KycService;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user-service/kyc")
@RequiredArgsConstructor
public class KycController {

    private final KycService kycService;

    /**
     * Submit verification request
     */
    @PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<UserVerificationDto> submitVerificationRequest(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId,
            @ModelAttribute UserVerificationRequest request) {
        return kycService.submitVerificationRequest(request, userId);
    }

    /**
     * Get verification request for current user
     */
    @GetMapping("/me")
    public ApiResponse<UserVerificationDto> getVerificationRequest(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId) {
        return kycService.getVerificationRequest(userId);
    }
}
