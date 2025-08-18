package com.chuadatten.product.entity;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    private String id;
    private String productId;
    private String url;      // CDN / S3
    private String alt;      // mô tả ảnh cho SEO/a11y
    private boolean main;    // ảnh chính
    private Integer position; // thứ tự hiển thị
    private Integer width;   // optional metadata
    private Integer height;
}