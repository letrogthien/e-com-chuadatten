package com.chuadatten.user.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class SellerRatingDto {
    private UUID id;
    private UUID sellerId;
    private UUID buyerId;
    private UUID transactionId;
    private Integer ratingScore;
    private String reviewText;
    private LocalDateTime createdAt;

}
