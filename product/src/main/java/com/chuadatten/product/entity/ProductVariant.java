package com.chuadatten.product.entity;

import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chuadatten.product.common.Status;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

@Document("product_variants")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@CompoundIndex(name = "uniq_product_attr", def = "{ 'productId': 1, 'attributesHash': 1 }", unique = true)

public class ProductVariant {
    @Id
    private String id;

    @Indexed
    private String productId;

    @Indexed(unique = true, sparse = true)
    private String sku; // optional nhưng nên unique nếu dùng ERP/inventory

    private Map<String, String> attributes; // {color:red, size:M}

    // Hash chuẩn hoá từ attributes để unique check & lookup nhanh
    private String attributesHash; // ví dụ: "color:red|size:m"

    // Giá override (nếu null -> dùng product.basePrice)
    private BigDecimal price;

    // Tồn kho an toàn cho concurrency
    private Integer availableQty; // còn có thể bán
    private Integer reservedQty; // đã giữ chỗ trong giỏ/đơn tạm
    private Integer soldQty; // đã bán (tuỳ nhu cầu)

    private Status status; // ACTIVE, INACTIVE, OUT_OF_STOCK

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}