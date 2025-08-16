package com.chuadatten.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chuadatten.user.dto.SellerApplicationDto;
import com.chuadatten.user.entity.SellerApplication;
import com.chuadatten.user.requests.SellerApplicationRequest;

@Mapper(componentModel = "spring")
public interface SellerApplicationMapper {
    @Mapping(target = "userId", source = "user.id")
    SellerApplicationDto toDTO(SellerApplication entity);

    @Mapping(target = "applicationStatus", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "rejectionReason", ignore = true)
    @Mapping(target = "reviewDate", ignore = true)
    @Mapping(target = "reviewerId", ignore = true)
    @Mapping(target = "submissionDate", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    SellerApplication toEntity(SellerApplicationRequest dto);
}
