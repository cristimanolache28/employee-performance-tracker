package com.dpx.tracker.service;

import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;

public interface RoleService {

    RoleResponseDto createRole(RoleCreateDto dto);
}
