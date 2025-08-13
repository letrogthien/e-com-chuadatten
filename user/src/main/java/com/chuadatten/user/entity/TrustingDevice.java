package com.chuadatten.user.entity;

import java.util.UUID;
import com.chuadatten.user.common.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TrustingDevice {
    private UUID userId;
    private UUID deviceInformationId;
    private Status status;
}
