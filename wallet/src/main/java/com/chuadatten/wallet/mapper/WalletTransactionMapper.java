package com.chuadatten.wallet.mapper;

import com.chuadatten.wallet.dto.WalletTransactionDto;
import com.chuadatten.wallet.entity.WalletTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WalletTransactionMapper {

    WalletTransactionDto toDto(WalletTransaction entity);

    WalletTransaction toEntity(WalletTransactionDto dto);

    List<WalletTransactionDto> toDtoList(List<WalletTransaction> entities);

    List<WalletTransaction> toEntityList(List<WalletTransactionDto> dtos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromDto(WalletTransactionDto dto, @MappingTarget WalletTransaction entity);

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
