package com.chuadatten.wallet.mapper;

import com.chuadatten.wallet.dto.WalletReservationDto;
import com.chuadatten.wallet.entity.WalletReservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WalletReservationMapper {

    WalletReservationDto toDto(WalletReservation entity);

    WalletReservation toEntity(WalletReservationDto dto);

    List<WalletReservationDto> toDtoList(List<WalletReservation> entities);

    List<WalletReservation> toEntityList(List<WalletReservationDto> dtos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromDto(WalletReservationDto dto, @MappingTarget WalletReservation entity);

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
