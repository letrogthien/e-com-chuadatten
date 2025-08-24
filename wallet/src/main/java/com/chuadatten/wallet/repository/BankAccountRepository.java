package com.chuadatten.wallet.repository;

import com.chuadatten.wallet.entity.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BankAccountRepository extends BaseRepository<BankAccount> {

    List<BankAccount> findByUserId(UUID userId);
}
