package com.dpx.tracker.service.impl;

import com.dpx.tracker.constants.ErrorMessage;
import com.dpx.tracker.constants.Messages;
import com.dpx.tracker.dto.role.DeleteRoleResponse;
import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;
import com.dpx.tracker.entity.Role;
import com.dpx.tracker.exception.RoleNotFoundException;
import com.dpx.tracker.mapper.RoleMapper;
import com.dpx.tracker.repository.RoleRepository;
import com.dpx.tracker.service.RoleService;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public RoleResponseDto createRole(RoleCreateDto dto) {
        Objects.requireNonNull(dto, ErrorMessage.ROLE_CREATE_DTO_NULL);
        Role role = RoleMapper.toEntity(dto);
        Role saved = roleRepository.save(role);
        return RoleMapper.toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleResponseDto getRoleById(UUID id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(MessageFormat.format(ErrorMessage.ROLE_NOT_FOUND, id)));
        return RoleMapper.toDto(role);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleResponseDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        if (roles.isEmpty()) {
            throw new RoleNotFoundException(ErrorMessage.ROLE_LIST_EMPTY);
        }
        return roles.stream()
                .map(RoleMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public DeleteRoleResponse deleteRoleById(UUID id) {
        roleRepository.findById(id)
                .ifPresentOrElse(role -> {
                    roleRepository.delete(role);
                    log.info("Role with id {} was deleted successfully", id);
                }, () -> {
                    throw new RoleNotFoundException(MessageFormat.format(ErrorMessage.ROLE_NOT_FOUND, id));
                });
        return new DeleteRoleResponse(Messages.ROLE_DELETED, id, Instant.now());
    }
}
