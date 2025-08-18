package com.chuadatten.product.requests;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lombok.Getter;

@Getter
public class ProductCreateRq {
    // product

    private String name;

    private String description;

    private List<String> categoryIds;

    private Map<String, String> attributesProduct;

    private BigDecimal basePrice;

    private List<String> tags;

    //product variant



    private Map<String, String> attributesVariant;


    private String attributesHash;


    private BigDecimal price;


    private Integer availableQty;


}