package com.chuadatten.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Data Transfer Object for ProductImage entity.
 * Used for transferring product image data between service layers and API endpoints.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductImageDto {

    /**
     * The unique identifier of the product image.
     */
    private String id;

    /**
     * The ID of the product this image belongs to.
     */
    private String productId;

    /**
     * The URL of the image.
     */
    private String url;

    /**
     * The alt text for the image (for accessibility and SEO).
     */
    private String altText;

    /**
     * Flag indicating if this is the primary/featured image.
     */
    private Boolean isPrimary;

    /**
     * The display order of the image.
     */
    private Integer sortOrder;
}
