package com.chuadatten.product.service;


import com.chuadatten.product.dto.CategoryDto;
import com.chuadatten.product.responses.ApiResponse;

public interface AdminService {
/**
     * Creates a new category.
     * 
     * @param dto the category data transfer object containing category information
     * @param userId the ID of the user performing the operation
     * @return an ApiResponse containing the created category DTO
     */
    ApiResponse<CategoryDto> create(CategoryDto dto, String userId);
    
    /**
     * Updates an existing category.
     * 
     * @param id the ID of the category to update
     * @param dto the category data transfer object containing updated information
     * @param userId the ID of the user performing the operation
     * @return an ApiResponse containing the updated category DTO
     */
    ApiResponse<CategoryDto> update(String id, CategoryDto dto, String userId);
    
    /**
     * Deletes a category by its ID.
     * 
     * @param id the ID of the category to delete
     * @param userId the ID of the user performing the operation
     * @return an ApiResponse indicating the success or failure of the operation
     */
    ApiResponse<Void> delete(String id, String userId);
    
    /**
     * Retrieves a category by its ID.
     * 
     * @param id the ID of the category to retrieve
     * @return an ApiResponse containing the requested category DTO
     */
    
} 