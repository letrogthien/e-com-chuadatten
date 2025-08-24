package com.chuadatten.wallet.entity;

import com.chuadatten.wallet.common.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bank_transfers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "withdrawal_request_id")
    private UUID withdrawalRequestId;

    @Column(name = "provider", length = 50)
    private String provider;

    @Column(name = "provider_transfer_id", length = 255)
    private String providerTransferId;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "currency", nullable = false, columnDefinition = "CHAR(3)")
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 30)
    private Status status;

    @Column(name = "provider_response", columnDefinition = "JSON")
    private String providerResponse;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (id == null) {
            id = UUID.randomUUID();
        }
        if (status == null) {
            status = Status.PENDING;
        }
    }
}
