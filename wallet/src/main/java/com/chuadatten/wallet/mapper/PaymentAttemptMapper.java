package com.chuadatten.wallet.mapper;

import com.chuadatten.wallet.dto.PaymentAttemptDto;
import com.chuadatten.wallet.entity.PaymentAttempt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentAttemptMapper {

    PaymentAttemptDto toDto(PaymentAttempt entity);

    PaymentAttempt toEntity(PaymentAttemptDto dto);

    List<PaymentAttemptDto> toDtoList(List<PaymentAttempt> entities);

    List<PaymentAttempt> toEntityList(List<PaymentAttemptDto> dtos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromDto(PaymentAttemptDto dto, @MappingTarget PaymentAttempt entity);
}
