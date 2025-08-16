package com.chuadatten.user.requests;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SellerRatingRequest {
    @NotNull(message = "Seller ID is required")
    private UUID sellerId;

    @NotNull(message = "Buyer ID is required")
    private UUID buyerId;

    @NotNull(message = "Transaction ID is required")
    private UUID transactionId;

    @NotNull(message = "Rating score is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Integer ratingScore;

    @Size(max = 1000, message = "Review text must be less than 1000 characters")
    private String reviewText;
}
