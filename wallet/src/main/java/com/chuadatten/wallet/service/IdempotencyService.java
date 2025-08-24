package com.chuadatten.wallet.service;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.chuadatten.wallet.dto.IdempotencyStoreDto;
import com.chuadatten.wallet.responses.ApiResponse;

public interface IdempotencyService {

    /**
     * Check or save idempotency key
     * @param idempotencyKey Idempotency key
     * @param resourceType Resource type (payment, withdrawal, etc.)
     * @param resourceId ID of the resource
     * @return ApiResponse containing idempotency store information
     */
    ApiResponse<IdempotencyStoreDto> checkOrSaveKey(String idempotencyKey, String resourceType, UUID resourceId);

    /**
     * Get previous response from idempotency key
     * @param idempotencyKey Idempotency key
     * @return ApiResponse containing previous response (JSON format)
     */
    ApiResponse<String> getPreviousResponse(String idempotencyKey);

    /**
     * Save response for idempotency key
     * @param idempotencyKey Idempotency key
     * @param response Response to save (JSON format)
     * @return ApiResponse containing updated idempotency store information
     */
    ApiResponse<IdempotencyStoreDto> saveResponse(String idempotencyKey, String response);

    /**
     * Get idempotency store information by ID
     * @param id ID of the idempotency store
     * @return ApiResponse containing idempotency store information
     */
    ApiResponse<IdempotencyStoreDto> getById(UUID id);

    /**
     * Get idempotency store information by key
     * @param idempotencyKey Idempotency key
     * @return ApiResponse containing idempotency store information
     */
    ApiResponse<IdempotencyStoreDto> getByIdempotencyKey(String idempotencyKey);

    /**
     * Get all idempotency stores with pagination
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of idempotency stores
     */
    ApiResponse<Page<IdempotencyStoreDto>> getAll(int page, int size);

    /**
     * Delete old idempotency stores (periodic cleanup)
     * @param daysOld Number of days to delete
     * @return ApiResponse containing number of deleted records
     */
    ApiResponse<Integer> cleanupOldRecords(int daysOld);
}
