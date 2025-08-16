package com.chuadatten.user.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.chuadatten.user.dto.BillingAddressDto;
import com.chuadatten.user.entity.BillingAddress;
import com.chuadatten.user.requests.BillingAddressRequest;

@Mapper(componentModel = "spring")
public interface BillingAddressMapper {
     @Mapping(target = "userId", source = "user.id")
     BillingAddressDto toDto(BillingAddress billingAddress);

     
     @Mapping(target = "user", ignore = true)
     @Mapping(target = "id", ignore = true)
     @Mapping(target = "createdAt", ignore = true)
     @Mapping(target = "updatedAt", ignore = true)
     BillingAddress toEntity(BillingAddressRequest billingAddressDto);

     @Mapping(target = "user", ignore = true)
     @Mapping(target = "id", ignore = true)
     @Mapping(target = "createdAt", ignore = true)
     @Mapping(target = "updatedAt", ignore = true)
     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
     void update(BillingAddressRequest billingAddressDto, @MappingTarget BillingAddress billingAddress);
}
