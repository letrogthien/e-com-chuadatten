package com.chuadatten.user.entity;

import java.util.UUID;
import com.chuadatten.user.common.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TrustingDevice {
    private UUID userId;
    private UUID deviceInformationId;
    private Status status;
}
