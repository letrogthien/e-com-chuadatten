package com.chuadatten.product.mapper;

import com.chuadatten.product.dto.ProductDto;
import com.chuadatten.product.dto.ProductImageDto;
import com.chuadatten.product.entity.Product;
import com.chuadatten.product.entity.ProductImage;
import com.chuadatten.product.requests.ProductUpdateRq;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * Mapper interface for converting between Product entity and ProductDto.
 * Uses MapStruct to generate implementation at compile time.
 * Handles embedded ProductImage objects within the Product entity.
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    /**
     * Converts a Product entity to a ProductDto.
     * Handles the embedded ProductImage objects.
     *
     * @param entity the Product entity to convert
     * @return the converted ProductDto
     */
    ProductDto toDto(Product entity);

    /**
     * Converts a ProductDto to a Product entity.
     * Handles the embedded ProductImage objects.
     * Ignores id, createdAt, and updatedAt fields as they are managed by the
     * database.
     *
     * @param dto the ProductDto to convert
     * @return the converted Product entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Product toEntity(ProductDto dto);

    /**
     * Updates an existing Product entity with values from a ProductDto.
     * Null values in the DTO will not be applied to the entity.
     * Handles the embedded ProductImage objects.
     *
     * @param dto    the ProductDto containing update values
     * @param entity the Product entity to update
     */


    void update(ProductUpdateRq dto, @MappingTarget Product entity);

    /**
     * Converts a list of ProductImage entities to a list of ProductImageDtos.
     *
     * @param images the list of ProductImage entities to convert
     * @return the converted list of ProductImageDtos
     */
    List<ProductImageDto> productImagesToProductImageDtos(List<ProductImage> images);

    /**
     * Converts a list of ProductImageDtos to a list of ProductImage entities.
     *
     * @param imageDtos the list of ProductImageDtos to convert
     * @return the converted list of ProductImage entities
     */
    List<ProductImage> productImageDtosToProductImages(List<ProductImageDto> imageDtos);
}
