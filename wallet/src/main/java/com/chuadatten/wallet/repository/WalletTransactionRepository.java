package com.chuadatten.wallet.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.chuadatten.wallet.entity.WalletTransaction;

@Repository
public interface WalletTransactionRepository extends BaseRepository<WalletTransaction> {

    Page<WalletTransaction> findByWalletId(UUID walletId, Pageable pageable);

    List<WalletTransaction> findByWalletIdAndCreatedAtBetween(UUID walletId, LocalDateTime startDate, LocalDateTime endDate);

    Optional<WalletTransaction> findByIdempotencyKey(String idempotencyKey);


}
