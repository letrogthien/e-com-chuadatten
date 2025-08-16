package com.chuadatten.user.services;

import com.chuadatten.user.common.RoleName;
import com.chuadatten.user.common.Status;
import com.chuadatten.user.dto.UserInfDto;
import com.chuadatten.user.responses.ApiResponse;

import java.util.UUID;

import org.springframework.data.domain.Page;

public interface AdminService {
    /*
     * Get all users
     * 
     */
    ApiResponse<Page<UserInfDto>> getUserList(int page, int size, Status status);

    /*
     * Get user
     * @Param userId
     * @return UserInfDto
     */
    ApiResponse<UserInfDto> getUser(UUID userId);

    /**
     * Approves a user's registration or application.
     *
     * @param userId the ID of the user to approve
     * @return ApiResponse containing a success or failure message
     */     
    ApiResponse<String> approveUser(UUID userId);

    /**
     * Rejects a user's registration or application.
     *
     * @param userId the ID of the user to reject
     * @return ApiResponse containing a success or failure message
     */
    ApiResponse<String> rejectUser(UUID userId);

    /**
     * Suspends a user's account.
     *
     * @param userId the ID of the user to suspend
     * @return ApiResponse containing a success or failure message
     */
    ApiResponse<String> suspendUser(UUID userId);

    /**
     * Deletes a user from the system.
     *
     * @param userId the ID of the user to delete
     * @return ApiResponse containing a success or failure message
     */
    ApiResponse<String> deleteUser(UUID userId);

    /**
     * Sets a specific role for a user.
     *
     * @param userId   the ID of the user
     * @param roleName the role to assign to the user
     * @return ApiResponse containing a success or failure message
     */
    ApiResponse<String> setRoleForUser(UUID userId, RoleName roleName);


    /**
     * Change status seller of user.
     * 
     * @Param userId
     * @Param status
     * @return ApiResponse containing a success or failure message
     */
    ApiResponse<UserInfDto> changeStatusSeller(UUID userId, Status status);
}