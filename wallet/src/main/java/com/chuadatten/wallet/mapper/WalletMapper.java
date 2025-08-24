package com.chuadatten.wallet.mapper;

import com.chuadatten.wallet.dto.WalletDto;
import com.chuadatten.wallet.entity.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WalletMapper {

    WalletDto toDto(Wallet entity);

    Wallet toEntity(WalletDto dto);

    List<WalletDto> toDtoList(List<Wallet> entities);

    List<Wallet> toEntityList(List<WalletDto> dtos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(WalletDto dto, @MappingTarget Wallet entity);

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
