
package com.chuadatten.transaction.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

import lombok.Getter;

@Getter
public class OrderLogCreateRq {

    @NotNull(message = "Order ID is required")
    private UUID orderId;

    @Size(max = 50, message = "From status must be less than 50 characters")
    private String fromStatus;

    @NotBlank(message = "To status is required")
    @Size(max = 50, message = "To status must be less than 50 characters")
    private String toStatus;

    private UUID changedBy;

    @Size(max = 500, message = "Note must be less than 500 characters")
    private String note;
}
