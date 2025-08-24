package com.chuadatten.wallet.service;

import com.chuadatten.wallet.dto.BankAccountDto;
import com.chuadatten.wallet.responses.ApiResponse;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

public interface BankAccountService {

    /**
     * Add a new bank account for user
     * @param userId ID of the user
     * @param bankCode Bank code
     * @param accountNumber Bank account number
     * @param accountName Account holder name
     * @return ApiResponse containing added bank account information
     */
    ApiResponse<BankAccountDto> addBankAccount(UUID userId, String bankCode, String accountNumber, String accountName);

    /**
     * Get all bank accounts of a user
     * @param userId ID of the user
     * @return ApiResponse containing list of bank accounts
     */
    ApiResponse<List<BankAccountDto>> getBankAccounts(UUID userId);

    /**
     * Get bank account information by ID
     * @param accountId ID of the bank account
     * @return ApiResponse containing bank account information
     */
    ApiResponse<BankAccountDto> getBankAccount(UUID accountId);

    /**
     * Delete bank account
     * @param accountId ID of the bank account
     * @param userId ID of the user (for permission check)
     * @return ApiResponse containing deletion status
     */
    ApiResponse<Boolean> deleteBankAccount(UUID accountId, UUID userId);

    /**
     * Update bank account information
     * @param accountId ID of the bank account
     * @param userId ID of the user (for permission check)
     * @param bankCode Bank code (can be null)
     * @param accountName Account holder name (can be null)
     * @return ApiResponse containing updated bank account information
     */
    ApiResponse<BankAccountDto> updateBankAccount(UUID accountId, UUID userId, String bankCode, String accountName);

    /**
     * Get all bank accounts with pagination (admin function)
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of bank accounts
     */
    ApiResponse<Page<BankAccountDto>> getAllBankAccounts(int page, int size);

    /**
     * Get all bank accounts of a user with pagination
     * @param userId ID of the user
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of bank accounts
     */
    ApiResponse<Page<BankAccountDto>> getUserBankAccounts(UUID userId, int page, int size);

    /**
     * Check if bank account belongs to user
     * @param accountId ID of the bank account
     * @param userId ID of the user
     * @return ApiResponse containing ownership status
     */
    ApiResponse<Boolean> isBankAccountOwnedByUser(UUID accountId, UUID userId);
}
