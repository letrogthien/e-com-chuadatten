package com.chuadatten.user.services.impl;

import com.chuadatten.user.anotation.CusAuditable;
import com.chuadatten.user.common.RoleName;
import com.chuadatten.user.common.Status;
import com.chuadatten.user.entity.Role;
import com.chuadatten.user.entity.UserAuth;
import com.chuadatten.user.entity.UserInf;
import com.chuadatten.user.entity.UserRole;
import com.chuadatten.user.exceptions.CustomException;
import com.chuadatten.user.exceptions.ErrorCode;
import com.chuadatten.user.repository.RoleRepository;
import com.chuadatten.user.repository.UserAuthRepository;
import com.chuadatten.user.repository.UserRoleRepository;
import com.chuadatten.user.responses.ApiResponse;
import com.chuadatten.user.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserAuthRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;



    @Override
    @CusAuditable(
            action = "APPROVE_USER",
            description = "Approving a user account"
    )
    public ApiResponse<String> approveUser(UUID userId) {
       return null;
    }

    @Override
    @CusAuditable(
            action = "REJECT_USER",
            description = "Rejecting a user account"
    )
    public ApiResponse<String> rejectUser(UUID userId) {
        UserAuth user = userRepository.findById(userId).orElseThrow(() ->
                new CustomException(ErrorCode.USER_NOT_FOUND)
        );
        if (!user.getStatus().equals(Status.ACTIVE)){
            return ApiResponse.<String>builder()
                    .message("User is not active")
                    .build();
        }
        user.setStatus(Status.BLOCKED);
        userRepository.save(user);
        return ApiResponse.<String>builder()
                .message("User rejected successfully")
                .build();
    }

    @Override
    @CusAuditable(
            action = "SUSPEND_USER",
            description = "Suspending a user account"
    )
    public ApiResponse<String> suspendUser(UUID userId) {
        return null;
    }

    @Override
    @CusAuditable(
            action = "DELETE_USER",
            description = "Deleting a user account"
    )
    public ApiResponse<String> deleteUser(UUID userId) {
        return null;
    }

    @Override
    @CusAuditable(
            action = "SET_ROLE",
            description = "Assigning a role to a user"
    )
    public ApiResponse<String> setRoleForUser(UUID userId, RoleName roleName) {
        UserAuth user = userRepository.findById(userId).orElseThrow(() ->
                new CustomException(ErrorCode.USER_NOT_FOUND)
        );
        if (user.getUserRoles().stream().anyMatch(role -> role.getRole().getName().equals(roleName))) {
            return ApiResponse.<String>builder()
                    .message("User already has this role")
                    .build();
        }
        Role role = roleRepository.findByName(roleName.name()).orElseThrow(() ->
                new CustomException(ErrorCode.ROLE_NOT_FOUND)
        );
        UserRole userRole = UserRole.builder().role(role).user(user).build();
        userRoleRepository.save(userRole);
        userRepository.save(user);
        return ApiResponse.<String>builder()
                .message("Role " + roleName + " assigned to user successfully")
                .build();
    }
}
