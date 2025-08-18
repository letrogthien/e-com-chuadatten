package com.chuadatten.product.mapper;

import com.chuadatten.product.dto.CategoryDto;
import com.chuadatten.product.entity.Category;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper interface for converting between Category entity and CategoryDto.
 * Uses MapStruct to generate implementation at compile time.
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {

    /**
     * Converts a Category entity to a CategoryDto.
     *
     * @param entity the Category entity to convert
     * @return the converted CategoryDto
     */
    CategoryDto toDto(Category entity);

    /**
     * Converts a CategoryDto to a Category entity.
     * Ignores id, createdAt, and updatedAt fields as they are managed by the database.
     *
     * @param dto the CategoryDto to convert
     * @return the converted Category entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category toEntity(CategoryDto dto);

    /**
     * Updates an existing Category entity with values from a CategoryDto.
     * Null values in the DTO will not be applied to the entity.
     *
     * @param dto the CategoryDto containing update values
     * @param entity the Category entity to update
     */
    void update(CategoryDto dto, @MappingTarget Category entity);

    List<CategoryDto> toDtoList(List<Category> category);
}
