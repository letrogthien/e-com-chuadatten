package com.chuadatten.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Data Transfer Object for ProductReview entity.
 * Used for transferring product review data between service layers and API endpoints.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewDto {

    /**
     * The unique identifier of the product review.
     */
    private String id;

    /**
     * The ID of the product being reviewed.
     */
    private String productId;

    /**
     * The ID of the user who left the review.
     */
    private String userId;

    /**
     * The display name of the user (denormalized for UI).
     */
    private String userName;

    /**
     * The rating given by the user (1-5 stars).
     */
    private Integer rating;

    /**
     * The short title of the review.
     */
    private String title;

    /**
     * The full text of the review comment.
     */
    private String comment;

    /**
     * The status of the review (PENDING, APPROVED, REJECTED).
     */
    private String status;

    /**
     * The response from an admin to the review.
     */
    private String adminResponse;

    /**
     * The timestamp when the admin response was added.
     */
    private Instant adminResponseAt;

    /**
     * The timestamp when the review was created.
     */
    private Instant createdAt;

    /**
     * The timestamp when the review was last updated.
     */
    private Instant updatedAt;
}
