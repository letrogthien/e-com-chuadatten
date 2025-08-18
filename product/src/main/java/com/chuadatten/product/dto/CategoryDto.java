package com.chuadatten.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

/**
 * Data Transfer Object for Category entity.
 * Used for transferring category data between service layers and API endpoints.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    /**
     * The unique identifier of the category.
     */
    private String id;

    /**
     * The SEO-friendly unique slug for the category.
     */
    private String slug;

    /**
     * The display name of the category.
     */
    private String name;

    /**
     * The ID of the parent category (null for root categories).
     */
    private String parentId;

    /**
     * The list of ancestor category IDs (from root to parent).
     */
    private List<String> ancestors;

    /**
     * The hierarchical path of the category (e.g., "electronics/phones/smartphones").
     */
    private String path;

    /**
     * The sort order for UI display.
     */
    private Integer sortOrder;

    /**
     * The status of the category.
     */
    private String status;

    /**
     * The timestamp when the category was created.
     */
    private Instant createdAt;

    /**
     * The timestamp when the category was last updated.
     */
    private Instant updatedAt;
}
