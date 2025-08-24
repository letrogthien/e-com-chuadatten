package com.chuadatten.wallet.repository;

import com.chuadatten.wallet.entity.Wallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalletRepository extends BaseRepository<Wallet> {

    Optional<Wallet> findByUserIdAndCurrency(UUID userId, String currency);

    List<Wallet> findByUserId(UUID userId);

    @Query("SELECT w FROM Wallet w WHERE w.status = 1")
    List<Wallet> findAllActive();

    @Query("SELECT w FROM Wallet w WHERE w.userId = :userId AND w.status = 1")
    List<Wallet> findActiveByUserId(@Param("userId") UUID userId);
}
