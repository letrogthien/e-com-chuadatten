package com.chuadatten.user.controller;

import com.chuadatten.user.common.RoleName;
import com.chuadatten.user.common.Status;
import com.chuadatten.user.dto.UserInfDto;
import com.chuadatten.user.responses.ApiResponse;
import com.chuadatten.user.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    /**
     * Get all users with pagination and status filter.
     */
    @GetMapping
    public ApiResponse<Page<UserInfDto>> getUserList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Status status
    ) {
        return adminService.getUserList(page, size, status);
    }

    /**
     * Get a user by ID.
     */
    @GetMapping("/{userId}")
    public ApiResponse<UserInfDto> getUser(@PathVariable UUID userId) {
        return adminService.getUser(userId);
    }

    /**
     * Approve a user.
     */
    @PostMapping("/{userId}/approve")
    public ApiResponse<String> approveUser(@PathVariable UUID userId) {
        return adminService.approveUser(userId);
    }

    /**
     * Reject a user.
     */
    @PostMapping("/{userId}/reject")
    public ApiResponse<String> rejectUser(@PathVariable UUID userId) {
        return adminService.rejectUser(userId);
    }

    /**
     * Suspend a user.
     */
    @PostMapping("/{userId}/suspend")
    public ApiResponse<String> suspendUser(@PathVariable UUID userId) {
        return adminService.suspendUser(userId);
    }

    /**
     * Delete a user.
     */
    @DeleteMapping("/{userId}")
    public ApiResponse<String> deleteUser(@PathVariable UUID userId) {
        return adminService.deleteUser(userId);
    }

    /**
     * Set a role for a user.
     */
    @PostMapping("/{userId}/roles")
    public ApiResponse<String> setRoleForUser(
            @PathVariable UUID userId,
            @RequestParam RoleName roleName
    ) {
        return adminService.setRoleForUser(userId, roleName);
    }

    /**
     * Change seller status for a user.
     */
    @PostMapping("/{userId}/seller-status")
    public ApiResponse<UserInfDto> changeStatusSeller(
            @PathVariable UUID userId,
            @RequestParam Status status
    ) {
        return adminService.changeStatusSeller(userId, status);
    }
}
