package com.chuadatten.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {
    private UUID id;
    private UUID userId;
    private UUID roleId;
    private String username;
    private String roleName;
}
