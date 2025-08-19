package com.chuadatten.product.requests;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Getter;


@Getter
public class VariantCreateRq {
    private String productId;

    private String sku;

    private Map<String, String> attributes;

    private String attributesHash;

    private BigDecimal price;

    private Integer availableQty;

}
