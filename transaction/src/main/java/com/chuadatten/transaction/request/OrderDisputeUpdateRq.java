
package com.chuadatten.transaction.request;

import com.chuadatten.transaction.common.Status;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

import lombok.Getter;

@Getter
public class OrderDisputeUpdateRq {

    @NotNull(message = "Dispute ID is required")
    private UUID id;

    private Status status;
}
