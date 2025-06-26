package com.dpx.tracker.service;

import com.dpx.tracker.dto.role.DeleteRoleResponse;
import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;

import java.util.List;
import java.util.UUID;

public interface RoleService {

    RoleResponseDto createRole(RoleCreateDto dto);

    RoleResponseDto getRoleById(UUID id);

    public List<RoleResponseDto> getAllRoles();

    DeleteRoleResponse deleteRoleById(UUID id);

    public RoleResponseDto updateRoleById(UUID id, RoleCreateDto roleCreateDto);
}
