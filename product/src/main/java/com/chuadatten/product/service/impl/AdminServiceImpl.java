package com.chuadatten.product.service.impl;

import org.springframework.stereotype.Service;

import com.chuadatten.product.dto.CategoryDto;
import com.chuadatten.product.repository.CategoryRepository;
import com.chuadatten.product.responses.ApiResponse;
import com.chuadatten.product.service.AdminService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final CategoryRepository categoryRepository;


    @Override
    public ApiResponse<CategoryDto> create(CategoryDto dto, String userId) {
        return null;
    }

    @Override
    public ApiResponse<CategoryDto> update(String id, CategoryDto dto, String userId) {
        return null;
    }

    @Override
    public ApiResponse<Void> delete(String id, String userId) {
        return null;
    }
    
}
