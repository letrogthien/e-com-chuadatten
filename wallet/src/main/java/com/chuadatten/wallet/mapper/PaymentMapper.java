package com.chuadatten.wallet.mapper;

import com.chuadatten.wallet.dto.PaymentDto;
import com.chuadatten.wallet.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentMapper {

    PaymentDto toDto(Payment entity);

    Payment toEntity(PaymentDto dto);

    List<PaymentDto> toDtoList(List<Payment> entities);

    List<Payment> toEntityList(List<PaymentDto> dtos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(PaymentDto dto, @MappingTarget Payment entity);

    default Long mapBigDecimalToLong(BigDecimal value) {
        if (value == null) {
            return null;
        }
        return value.longValue();
    }

    default BigDecimal mapLongToBigDecimal(Long value) {
        if (value == null) {
            return null;
        }
        return BigDecimal.valueOf(value);
    }
}
