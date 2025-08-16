package com.chuadatten.user.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.chuadatten.user.dto.UserInfDto;
import com.chuadatten.user.entity.UserInf;
import com.chuadatten.user.requests.UpdateUserRequest;

@Mapper(componentModel = "spring")
public interface UserInforMapper {
    UserInfDto toDto(UserInf userInf);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "avatarUrl", ignore = true)
    @Mapping(target = "billingAddresses", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deleteKycRequests", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isSeller", ignore = true)
    @Mapping(target = "preferences", ignore = true)
    @Mapping(target = "sellerApplications", ignore = true)
    @Mapping(target = "sellerRatings", ignore = true)
    @Mapping(target = "transactions", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "userVerifications", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdateUserRequest u, @MappingTarget UserInf userInf);

}