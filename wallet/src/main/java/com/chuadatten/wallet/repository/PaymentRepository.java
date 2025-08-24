package com.chuadatten.wallet.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.chuadatten.wallet.entity.Payment;

@Repository
public interface PaymentRepository extends BaseRepository<Payment> {

    Page<Payment> findByUserId(UUID userId, Pageable pageable);

    List<Payment> findByOrderId(UUID orderId);

    List<Payment> findByWalletId(UUID walletId);

    Optional<Payment> findByIdempotencyKey(String idempotencyKey);


}
