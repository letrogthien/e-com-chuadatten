package com.chuadatten.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import com.chuadatten.user.dto.UserVerificationDto;
import com.chuadatten.user.entity.UserVerification;

@Mapper(componentModel = "spring")
public interface UserKycMapper {

    @Mapping(target = "userId", source = "user.id")
    UserVerificationDto toDto(UserVerification e);


}
