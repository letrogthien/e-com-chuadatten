package com.chuadatten.user.services;

import java.util.UUID;

import com.chuadatten.user.dto.UserVerificationDto;
import com.chuadatten.user.requests.UserVerificationRequest;
import com.chuadatten.user.responses.ApiResponse;

public interface KycService {
    /**
     * Submit verification request
     * 
     * @param UserVerificationRequest
     * @param UserId
     * @return ApiResponse<UserVerificationDto>
     */
    ApiResponse<UserVerificationDto> submitVerificationRequest(UserVerificationRequest userVerificationRequest, UUID userId);


    /**
     * Get verification request
     * 
     * @param UserId
     * @return ApiResponse<UserVerificationDto>
     */
    ApiResponse<UserVerificationDto> getVerificationRequest(UUID userId);
}
