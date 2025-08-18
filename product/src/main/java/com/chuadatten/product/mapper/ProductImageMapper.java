package com.chuadatten.product.mapper;

import com.chuadatten.product.dto.ProductImageDto;
import com.chuadatten.product.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper interface for converting between ProductImage entity and ProductImageDto.
 * Uses MapStruct to generate implementation at compile time.
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductImageMapper {

    /**
     * Converts a ProductImage entity to a ProductImageDto.
     *
     * @param entity the ProductImage entity to convert
     * @return the converted ProductImageDto
     */
    ProductImageDto toDto(ProductImage entity);

    /**
     * Converts a ProductImageDto to a ProductImage entity.
     * Ignores id field as it is managed by the database.
     *
     * @param dto the ProductImageDto to convert
     * @return the converted ProductImage entity
     */
    @Mapping(target = "id", ignore = true)
    ProductImage toEntity(ProductImageDto dto);

    /**
     * Updates an existing ProductImage entity with values from a ProductImageDto.
     * Null values in the DTO will not be applied to the entity.
     *
     * @param dto the ProductImageDto containing update values
     * @param entity the ProductImage entity to update
     */
    void update(ProductImageDto dto, @MappingTarget ProductImage entity);
}
