package com.chuadatten.product.controller;

import com.chuadatten.product.dto.CategoryDto;
import com.chuadatten.product.responses.ApiResponse;
import com.chuadatten.product.service.AdminService;
import com.chuadatten.product.anotation.JwtClaims;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product-service/admin/categories")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public ApiResponse<CategoryDto> create(@RequestBody CategoryDto dto,
                                           @Parameter(hidden = true) @JwtClaims("id") UUID userId) {
        return adminService.create(dto, userId.toString());
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryDto> update(@PathVariable String id,
                                           @RequestBody CategoryDto dto,
                                           @Parameter(hidden = true) @JwtClaims("id") UUID userId) {
        return adminService.update(id, dto, userId.toString());
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable String id,
                                    @Parameter(hidden = true) @JwtClaims("id") UUID userId) {
        return adminService.delete(id, userId.toString());
    }
}