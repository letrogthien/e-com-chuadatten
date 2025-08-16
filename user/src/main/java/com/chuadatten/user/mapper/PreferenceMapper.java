package com.chuadatten.user.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.chuadatten.user.dto.PreferenceDto;
import com.chuadatten.user.entity.Preference;
import com.chuadatten.user.requests.UpdatePreferenceRequest;

@Mapper(componentModel = "spring")
public interface PreferenceMapper {
    @Mapping(target = "userId", source = "user.id")
    PreferenceDto toDto(Preference preference);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdatePreferenceRequest u, @MappingTarget Preference preference);


}
