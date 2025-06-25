package com.dpx.tracker.mapper;

import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;
import com.dpx.tracker.entity.Role;

public final class RoleMapper {

    private RoleMapper() {
        // constructor privat pentru a preveni instantierea
    }

    public static Role toEntity(RoleCreateDto roleCreateDto) {
        Role role = new Role();
        role.setName(roleCreateDto.name().toUpperCase());
        role.setDescription(roleCreateDto.description());
        return role;
    }

    public static RoleResponseDto toDto(Role role) {
        return new RoleResponseDto(
                role.getId(),
                role.getName(),
                role.getDescription()
        );
    }
}
