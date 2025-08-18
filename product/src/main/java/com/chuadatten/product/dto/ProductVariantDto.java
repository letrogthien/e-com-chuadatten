package com.chuadatten.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

/**
 * Data Transfer Object for ProductVariant entity.
 * Used for transferring product variant data between service layers and API endpoints.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantDto {

    /**
     * The unique identifier of the product variant.
     */
    private String id;

    /**
     * The ID of the product this variant belongs to.
     */
    private String productId;

    /**
     * The Stock Keeping Unit (SKU) for inventory tracking.
     */
    private String sku;

    /**
     * Variant attributes (e.g., color: red, size: M).
     */
    private Map<String, String> attributes;

    /**
     * Normalized hash of attributes for unique checking and fast lookup.
     */
    private String attributesHash;

    /**
     * The price of this variant (overrides product.basePrice if not null).
     */
    private BigDecimal price;

    /**
     * The available quantity that can be sold.
     */
    private Integer availableQty;

    /**
     * The quantity reserved in carts or temporary orders.
     */
    private Integer reservedQty;

    /**
     * The quantity already sold.
     */
    private Integer soldQty;

    /**
     * The status of the variant (e.g., ACTIVE, INACTIVE, OUT_OF_STOCK).
     */
    private String status;

    /**
     * The timestamp when the variant was created.
     */
    private Instant createdAt;

    /**
     * The timestamp when the variant was last updated.
     */
    private Instant updatedAt;
}
