package com.dpx.tracker.service.impl;

import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;
import com.dpx.tracker.entity.Role;
import com.dpx.tracker.mapper.RoleMapper;
import com.dpx.tracker.repository.RoleRepository;
import com.dpx.tracker.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public RoleResponseDto createRole(RoleCreateDto dto) {
        Objects.requireNonNull(dto, "RoleCreateDto cannot be null");
        Role role = RoleMapper.toEntity(dto);
        Role saved = roleRepository.save(role);
        return RoleMapper.toDto(saved);
    }
}
