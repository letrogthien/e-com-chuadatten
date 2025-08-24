package com.chuadatten.wallet.service;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.chuadatten.wallet.dto.BankTransferDto;
import com.chuadatten.wallet.dto.WithdrawalRequestDto;
import com.chuadatten.wallet.responses.ApiResponse;

public interface WithdrawalService {

    /**
     * Create a withdrawal request from wallet to bank account
     * @param userId ID of the user
     * @param walletId ID of the wallet
     * @param bankAccountId ID of the bank account
     * @param amount Withdrawal amount
     * @param currency Currency type
     * @param idempotencyKey Idempotency key to avoid duplicates
     * @return ApiResponse containing withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> requestWithdrawal(UUID userId, UUID walletId, UUID bankAccountId, Long amount, String currency, String idempotencyKey);

    /**
     * Get withdrawal status (pending/processing/completed/failed)
     * @param withdrawalId ID of the withdrawal request
     * @return ApiResponse containing withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> getWithdrawalStatus(UUID withdrawalId);

    /**
     * Get all withdrawal requests of a user
     * @param userId ID of the user
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of withdrawal requests
     */
    ApiResponse<Page<WithdrawalRequestDto>> getUserWithdrawals(UUID userId, int page, int size);

    /**
     * Process withdrawal (internal service that sends request to bank provider)
     * @param withdrawalId ID of the withdrawal request
     * @return ApiResponse containing updated withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> processWithdrawal(UUID withdrawalId);

    /**
     * Approve withdrawal request (admin function)
     * @param withdrawalId ID of the withdrawal request
     * @return ApiResponse containing updated withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> approveWithdrawal(UUID withdrawalId);

    /**
     * Reject withdrawal request (admin function)
     * @param withdrawalId ID of the withdrawal request
     * @param reason Reason for rejection
     * @return ApiResponse containing updated withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> rejectWithdrawal(UUID withdrawalId, String reason);

    /**
     * Cancel withdrawal request (only applicable when in pending status)
     * @param withdrawalId ID of the withdrawal request
     * @return ApiResponse containing cancelled withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> cancelWithdrawal(UUID withdrawalId);

    /**
     * Get bank transfer information related to withdrawal request
     * @param withdrawalId ID of the withdrawal request
     * @return ApiResponse containing bank transfer information
     */
    ApiResponse<BankTransferDto> getBankTransfer(UUID withdrawalId);

    /**
     * Handle callback from bank about transfer status
     * @param bankTransferId ID of the bank transfer
     * @param providerResponse Callback data from bank
     * @return ApiResponse containing updated bank transfer information
     */
    ApiResponse<BankTransferDto> handleBankTransferCallback(UUID bankTransferId, String providerResponse);
}
