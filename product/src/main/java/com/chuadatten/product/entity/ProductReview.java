package com.chuadatten.product.entity;

import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "product_reviews")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@CompoundIndex(name = "user_product_unique", def = "{ 'userId': 1, 'productId': 1 }")

public class ProductReview {
    @Id
    private String id;

    @Indexed
    private String productId;

    @Indexed
    private String userId;

    private String userName; // denormalized for UI

    @Indexed
    private Integer rating; // 1-5 stars

    private String title; // short title for the review
    private String comment; // full review text

    @Indexed
    private String status; // PENDING, APPROVED, REJECTED

    // Admin response fields
    private String adminResponse;
    private Instant adminResponseAt;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
