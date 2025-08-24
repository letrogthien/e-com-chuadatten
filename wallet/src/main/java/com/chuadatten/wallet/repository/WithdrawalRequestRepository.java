package com.chuadatten.wallet.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.chuadatten.wallet.entity.WithdrawalRequest;

@Repository
public interface WithdrawalRequestRepository extends BaseRepository<WithdrawalRequest> {

    Page<WithdrawalRequest> findByUserId(UUID userId, Pageable pageable);

    List<WithdrawalRequest> findByWalletId(UUID walletId);

    List<WithdrawalRequest> findByBankAccountId(UUID bankAccountId);

    Optional<WithdrawalRequest> findByIdempotencyKey(String idempotencyKey);


}
