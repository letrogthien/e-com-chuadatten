package com.chuadatten.wallet.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWalletStatusRequest {
    private Integer status;
    private String reason;
    private String notes;
}
