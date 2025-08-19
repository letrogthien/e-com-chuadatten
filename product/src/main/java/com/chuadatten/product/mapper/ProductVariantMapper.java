package com.chuadatten.product.mapper;

import com.chuadatten.product.dto.ProductVariantDto;
import com.chuadatten.product.entity.ProductVariant;
import com.chuadatten.product.requests.VariantUpdateRq;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper interface for converting between ProductVariant entity and ProductVariantDto.
 * Uses MapStruct to generate implementation at compile time.
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductVariantMapper {

    /**
     * Converts a ProductVariant entity to a ProductVariantDto.
     *
     * @param entity the ProductVariant entity to convert
     * @return the converted ProductVariantDto
     */
    ProductVariantDto toDto(ProductVariant entity);



    /**
     * Updates an existing ProductVariant entity with values from a ProductVariantDto.
     * Null values in the DTO will not be applied to the entity.
     *
     * @param dto the ProductVariantDto containing update values
     * @return the ProductVariant entity to update
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(VariantUpdateRq rq, @MappingTarget ProductVariant entity);
}
