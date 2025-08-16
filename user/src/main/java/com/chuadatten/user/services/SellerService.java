package com.chuadatten.user.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chuadatten.user.dto.SellerApplicationDto;
import com.chuadatten.user.dto.SellerRatingDto;
import com.chuadatten.user.requests.SellerRatingRequest;
import com.chuadatten.user.responses.ApiResponse;

public interface SellerService {

    /**
     * Get seller rating
     * 
     * @param userId
     * 
     * @return: ApiResponse<Page<SellerRatingDto>>
     */
    ApiResponse<Page<SellerRatingDto>> getSellerRating(UUID userId, SellerRatingDto request, Pageable pageable);

    /**
     * Rating seller.
     * 
     * @param userId
     * 
     * @param SellerRatingRequest: rating
     * 
     * @return: ApiResponse<SellerRatingDto>
     */
    ApiResponse<SellerRatingDto> ratingSeller(UUID userId, SellerRatingRequest sellerRatingRequest);

    /**
     * Submit seller aplication.
     * 
     * @param userId
     * @param SellerApplicationRequest
     * @return: ApiResponse<SellerApplicationDto>
     */
    ApiResponse<String> submitSellerApplication(UUID userId);


    /**
     * Get seller application
     * @param userId
     * @return: ApiResponse<SellerApplicationDto>
     */

    ApiResponse<SellerApplicationDto> getSellerApplication(UUID userId);
    
}
