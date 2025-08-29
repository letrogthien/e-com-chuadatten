package com.chuadatten.wallet.service;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.chuadatten.wallet.common.Status;
import com.chuadatten.wallet.dto.BankAccountDto;
import com.chuadatten.wallet.dto.PaymentDto;
import com.chuadatten.wallet.dto.WalletDto;
import com.chuadatten.wallet.dto.WithdrawalRequestDto;
import com.chuadatten.wallet.request.RejectWithdrawalRequest;
import com.chuadatten.wallet.responses.ApiResponse;

public interface AdminService {




    /**
     * View wallets of all users
     * @param filters Filter criteria (userId, currency, status, etc.)
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of wallets
     */
    ApiResponse<Page<WalletDto>> viewAllWallets(Map<String, Object> filters, int page, int size);

    /**
     * Change status of a wallet
     * @param walletId ID of the wallet to change status
     * @param status New status to set
     * @return ApiResponse containing updated wallet details
     * 
     * */
    ApiResponse<WalletDto> changeStatusWallet(UUID walletId, Status status);

    /**
     * View all payments
     * @param filters Filter criteria (userId, status, type, etc.)
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of payments
     */
    ApiResponse<Page<PaymentDto>> viewAllPayments(Map<String, Object> filters, int page, int size);

    /**
     * View all withdrawal requests
     * @param filters Filter criteria (userId, status, etc.)
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of withdrawal requests
     */
    ApiResponse<Page<WithdrawalRequestDto>> viewAllWithdrawals(Map<String, Object> filters, int page, int size);

    /**
     * Approve withdrawal request
     * @param withdrawalId ID of the withdrawal request
     * @return ApiResponse containing updated withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> approveWithdrawal(UUID withdrawalId);

    /**
     * Reject withdrawal request
     * @param withdrawalId ID of the withdrawal request
     * @param request RejectWithdrawalRequest containing reason and other rejection information
     * @return ApiResponse containing updated withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> rejectWithdrawal(UUID withdrawalId, RejectWithdrawalRequest request);

    /**
     * View all bank accounts
     * @param filters Filter criteria (userId, bankCode, etc.)
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of bank accounts
     */
    ApiResponse<Page<BankAccountDto>> viewAllBankAccounts(Map<String, Object> filters, int page, int size);


    /**
     * Get system overview statistics
     * @return ApiResponse containing statistics information
     */
    ApiResponse<Map<String, Object>> getSystemStatistics();

    /**
     * Get list of suspicious transactions (needs investigation)
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of suspicious transactions
     */
    ApiResponse<Page<Object>> getSuspiciousTransactions(int page, int size);
}
