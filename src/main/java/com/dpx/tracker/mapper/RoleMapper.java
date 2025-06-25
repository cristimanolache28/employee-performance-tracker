package com.dpx.tracker.mapper;

import com.dpx.tracker.dto.role.RoleResponseDto;
import com.dpx.tracker.entity.Role;

public final class RoleMapper {

    public static RoleResponseDto toDto(Role role) {
        return new RoleResponseDto(
                role.getId(),
                role.getRole()
        );
    }
}
