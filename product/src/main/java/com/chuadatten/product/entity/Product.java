package com.chuadatten.product.entity;

import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chuadatten.product.common.Status;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Document(collection = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String id;

    @Indexed
    private String userId;

    @Indexed(unique = true)
    private String slug;             

    @TextIndexed(weight = 10)
    private String name;

    @TextIndexed(weight = 3)
    private String description;

    @Indexed
    private Status active;

    @Indexed
    private List<String> categoryIds; // reference -> categories

    private List<ProductImage> images; // embed images (small)

    // Thuộc tính động để filter/search (color, brand, platform...)
    private Map<String, String> attributes; // nhẹ -> embed

    // Giá cơ sở (variant có thể override)
    private BigDecimal basePrice;
    private String currency; // ISO 4217, ví dụ "USD", "VND"

    // SEO / discovery
    @Indexed
    private List<String> tags;

    // Aggregate (được cập nhật bằng change stream/cron)
    private Double ratingAvg;   // 0..5
    private Integer ratingCount;

    // Soft delete / lifecycle
    private Instant softDeletedAt; // null nếu chưa xóa mềm

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}