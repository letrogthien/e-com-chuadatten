package com.chuadatten.user.services.impl;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chuadatten.user.dto.SellerApplicationDto;
import com.chuadatten.user.dto.SellerRatingDto;
import com.chuadatten.user.entity.SellerApplication;
import com.chuadatten.user.entity.SellerRating;
import com.chuadatten.user.exceptions.CustomException;
import com.chuadatten.user.exceptions.ErrorCode;
import com.chuadatten.user.mapper.SellerApplicationMapper;
import com.chuadatten.user.mapper.SellerRatingMapper;
import com.chuadatten.user.repository.DslRepository;
import com.chuadatten.user.repository.SellerApplicationRepository;
import com.chuadatten.user.repository.SellerRatingRepository;
import com.chuadatten.user.repository.TransactionRepository;
import com.chuadatten.user.repository.UserInfRepository;
import com.chuadatten.user.requests.SellerRatingRequest;
import com.chuadatten.user.responses.ApiResponse;
import com.chuadatten.user.services.SellerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {
    private final DslRepository dslRepository;
    private final SellerRatingRepository sellerRatingRepository;
    private final SellerRatingMapper sellerRatingMapper;
    private final UserInfRepository userInfRepository;
    private final TransactionRepository transactionRepository;
    private final SellerApplicationRepository sellerApplicationRepository;
    private final SellerApplicationMapper sellerApplicationMapper;

    @Override
    public ApiResponse<Page<SellerRatingDto>> getSellerRating(UUID userId, SellerRatingDto request, Pageable pageable) {
        Page<SellerRatingDto> sellerRating = dslRepository.getSellerRatingDynamic(userId, request, pageable)
                .map(sellerRatingMapper::toDto);
        return ApiResponse.<Page<SellerRatingDto>>builder()
                .data(sellerRating)
                .build();
    }

    @Override
    public ApiResponse<SellerRatingDto> ratingSeller(UUID userId, SellerRatingRequest sellerRatingRequest) {
        if (userId != sellerRatingRequest.getBuyerId()) {
            throw new CustomException(ErrorCode.UNAUTHORIZED);

        }
        SellerRating sellerRating = sellerRatingMapper.toEntity(sellerRatingRequest);
        sellerRating.setBuyer(userInfRepository.findById(sellerRatingRequest.getBuyerId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND)));
        sellerRating.setSeller(userInfRepository.findById(sellerRatingRequest.getSellerId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND)));
        sellerRating.setTransaction(transactionRepository.findById(sellerRatingRequest.getTransactionId())
                .orElseThrow(() -> new CustomException(ErrorCode.TRANSACTION_NOT_FOUND)));
        sellerRatingRepository.save(sellerRating);
        return ApiResponse.<SellerRatingDto>builder()
                .data(sellerRatingMapper.toDto(sellerRating))
                .build();
    }

    @Override
    public ApiResponse<String> submitSellerApplication(UUID userId) {
        SellerApplication sellerApplication = SellerApplication.builder()
                .user(userInfRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND)))
                .build();
        sellerApplicationRepository.save(sellerApplication);
        return ApiResponse.<String>builder()
                .data("Success")
                .build();
    }

    @Override
    public ApiResponse<SellerApplicationDto> getSellerApplication(UUID userId) {
        SellerApplication sellerApplication = sellerApplicationRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        return ApiResponse.<SellerApplicationDto>builder()
                .data(sellerApplicationMapper.toDTO(sellerApplication))
                .build();
    }

}
