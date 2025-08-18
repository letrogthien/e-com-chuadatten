package com.chuadatten.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.chuadatten.product.common.Status;

/**
 * Data Transfer Object for Product entity.
 * Used for transferring product data between service layers and API endpoints.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    /**
     * The unique identifier of the product.
     */
    private String id;

    private String userId;

    /**
     * The SEO-friendly unique slug for the product.
     */
    private String slug;

    /**
     * The name of the product.
     */
    private String name;

    /**
     * The description of the product.
     */
    private String description;

    /**
     * Flag indicating if the product is active and available for purchase.
     */
    private Status active;

    /**
     * List of category IDs that the product belongs to.
     */
    private List<String> categoryIds;

    /**
     * List of product images.
     */
    private List<ProductImageDto> images;

    /**
     * Dynamic attributes for filtering and searching (e.g., color, brand,
     * platform).
     */
    private Map<String, String> attributes;

    /**
     * The base price of the product.
     */
    private BigDecimal basePrice;

    /**
     * The currency code (ISO 4217, e.g., "USD", "VND").
     */
    private String currency;

    /**
     * List of tags for SEO and discovery purposes.
     */
    private List<String> tags;

    /**
     * The average rating of the product (0-5).
     */
    private Double ratingAvg;

    /**
     * The total number of ratings for the product.
     */
    private Integer ratingCount;

    /**
     * The timestamp when the product was soft deleted (null if not deleted).
     */
    private Instant softDeletedAt;

    /**
     * The timestamp when the product was created.
     */
    private Instant createdAt;

    /**
     * The timestamp when the product was last updated.
     */
    private Instant updatedAt;
}
