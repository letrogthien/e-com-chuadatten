package com.chuadatten.wallet.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.chuadatten.wallet.entity.BankTransfer;

@Repository
public interface BankTransferRepository extends BaseRepository<BankTransfer> {

    List<BankTransfer> findByWithdrawalRequestId(UUID withdrawalRequestId);

}
