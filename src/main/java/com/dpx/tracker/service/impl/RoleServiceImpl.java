package com.dpx.tracker.service.impl;

import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;
import com.dpx.tracker.entity.Role;
import com.dpx.tracker.mapper.RoleMapper;
import com.dpx.tracker.repository.RoleRepository;
import com.dpx.tracker.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleResponseDto createRole(RoleCreateDto dto) {
        Role role = RoleMapper.toEntity(dto);
//        name.setName(dto.name());
//        name.setDescription(dto.description());
        Role saved = roleRepository.save(role);
        return RoleMapper.toDto(saved);
    }
}
