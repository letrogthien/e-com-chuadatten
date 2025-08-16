package com.chuadatten.user.controller;

import com.chuadatten.user.anotation.JwtClaims;
import com.chuadatten.user.dto.SellerApplicationDto;
import com.chuadatten.user.dto.SellerRatingDto;
import com.chuadatten.user.requests.SellerRatingRequest;
import com.chuadatten.user.responses.ApiResponse;
import com.chuadatten.user.services.SellerService;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    /**
     * Get seller rating with pagination & optional filter.
     */
    @GetMapping("/ratings")
    public ApiResponse<Page<SellerRatingDto>> getSellerRating(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId,
            SellerRatingDto request,   
            Pageable pageable
    ) {
        return sellerService.getSellerRating(userId, request, pageable);
    }

    /**
     * Rate a seller.
     */
    @PostMapping("/ratings")
    public ApiResponse<SellerRatingDto> ratingSeller(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId,
            @RequestBody SellerRatingRequest sellerRatingRequest
    ) {
        return sellerService.ratingSeller(userId, sellerRatingRequest);
    }

    /**
     * Submit seller application.
     */
    @PostMapping("/applications")
    public ApiResponse<String> submitSellerApplication(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId
    ) {
        return sellerService.submitSellerApplication(userId);
    }

    /**
     * Get current user's seller application.
     */
    @GetMapping("/applications/me")
    public ApiResponse<SellerApplicationDto> getSellerApplication(
            @Parameter(hidden = true) @JwtClaims("id") UUID userId
    ) {
        return sellerService.getSellerApplication(userId);
    }
}
