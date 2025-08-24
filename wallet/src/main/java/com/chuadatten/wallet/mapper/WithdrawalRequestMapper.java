package com.chuadatten.wallet.mapper;

import com.chuadatten.wallet.dto.WithdrawalRequestDto;
import com.chuadatten.wallet.entity.WithdrawalRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WithdrawalRequestMapper {

    WithdrawalRequestDto toDto(WithdrawalRequest entity);

    WithdrawalRequest toEntity(WithdrawalRequestDto dto);

    List<WithdrawalRequestDto> toDtoList(List<WithdrawalRequest> entities);

    List<WithdrawalRequest> toEntityList(List<WithdrawalRequestDto> dtos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(WithdrawalRequestDto dto, @MappingTarget WithdrawalRequest entity);

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
