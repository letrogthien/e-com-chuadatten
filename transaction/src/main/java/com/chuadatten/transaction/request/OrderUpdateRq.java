
package com.chuadatten.transaction.request;

import com.chuadatten.transaction.common.Status;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

import lombok.Getter;

@Getter
public class OrderUpdateRq {

    @NotNull(message = "Order ID is required")
    private UUID id;

    private Status status;

    private Status paymentStatus;

    private boolean auditFlag;
}
