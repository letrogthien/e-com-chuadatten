package com.chuadatten.product.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Request object for creating a new Product Variant.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantRq {

    /**
     * The ID of the product this variant belongs to.
     */
    private String productId;

    /**
     * Stock Keeping Unit for inventory tracking.
     */
    private String sku;

    /**
     * Variant attributes (e.g., color: red, size: M).
     */
    private Map<String, String> attributes;

    /**
     * Optional price override for this variant.
     */
    private BigDecimal price;

    /**
     * The available quantity that can be sold.
     */
    private Integer availableQty;

    /**
     * The status of the variant (e.g., ACTIVE, INACTIVE, OUT_OF_STOCK).
     */
    private String status;
}
