package com.chuadatten.user.controller;

import com.chuadatten.user.anotation.JwtClaims;
import com.chuadatten.user.dto.BillingAddressDto;
import com.chuadatten.user.dto.PreferenceDto;
import com.chuadatten.user.dto.UserInfDto;
import com.chuadatten.user.requests.BillingAddressRequest;
import com.chuadatten.user.requests.UpdatePreferenceRequest;
import com.chuadatten.user.requests.UpdateUserRequest;
import com.chuadatten.user.responses.ApiResponse;
import com.chuadatten.user.services.UserInforService;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/users/me")
@RequiredArgsConstructor
public class UserInforController {

    private final UserInforService userInforService;

    /**
     * Get current user info
     */
    @GetMapping
    public ApiResponse<UserInfDto> getUserInfo(@Parameter(hidden = true) @JwtClaims("id") UUID userId) {
        return userInforService.getUserById(userId);
    }

    /**
     * Update user info
     */
    @PutMapping
    public ApiResponse<UserInfDto> updateUserInfo(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId,
            @RequestBody UpdateUserRequest updateUserRequest
    ) {
        return userInforService.updateUser(userId, updateUserRequest);
    }

    /**
     * Update user avatar
     */
    @PostMapping(value = "/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<UserInfDto> updateAvatar(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId,
            @RequestPart("avatar") MultipartFile avatar
    ) {
        return userInforService.updateAvatar(userId, avatar);
    }

    /**
     * Get user preference
     */
    @GetMapping("/preferences")
    public ApiResponse<PreferenceDto> getPreference(@Parameter(hidden = true) @JwtClaims("id") UUID userId) {
        return userInforService.getPreference(userId);
    }

    /**
     * Update user preference
     */
    @PutMapping("/preferences")
    public ApiResponse<PreferenceDto> updatePreference(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId,
            @RequestBody UpdatePreferenceRequest updatePreferenceRequest
    ) {
        return userInforService.updatePreference(userId, updatePreferenceRequest);
    }

    /**
     * Get billing address
     */
    @GetMapping("/billing-address")
    public ApiResponse<BillingAddressDto> getBillingAddress(@Parameter(hidden = true) @JwtClaims("id") UUID userId) {
        return userInforService.getBillingAddress(userId);
    }

    /**
     * Create billing address
     */
    @PostMapping("/billing-address")
    public ApiResponse<BillingAddressDto> createBillingAddress(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId,
            @RequestBody BillingAddressRequest billingAddressRequest
    ) {
        return userInforService.createBillingAddress(userId, billingAddressRequest);
    }

    /**
     * Update billing address
     */
    @PutMapping("/billing-address")
    public ApiResponse<BillingAddressDto> updateBillingAddress(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId,
            @RequestBody BillingAddressRequest billingAddressRequest
    ) {
        return userInforService.updateBillingAddress(userId, billingAddressRequest);
    }
}
