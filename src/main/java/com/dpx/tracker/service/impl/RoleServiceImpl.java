package com.dpx.tracker.service.impl;

import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;
import com.dpx.tracker.entity.Role;
import com.dpx.tracker.exception.ResourceNotFoundException;
import com.dpx.tracker.mapper.RoleMapper;
import com.dpx.tracker.repository.RoleRepository;
import com.dpx.tracker.repository.UserRepository;
import com.dpx.tracker.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public RoleResponseDto getRoleById(UUID id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role with id " + id + " not found",
                        "BAD_USER_INPUT",
                        HttpStatus.NOT_FOUND));
        return RoleMapper.toDto(role);
    }

    @Override
    public List<RoleResponseDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        if (roles.isEmpty()) {
            throw new ResourceNotFoundException("Roles list is empty");
        }
        return roles.stream()
                .map(RoleMapper::toDto)
                .toList();
    }
}
