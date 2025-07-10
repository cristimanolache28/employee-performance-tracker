package com.dpx.tracker;

import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;
import com.dpx.tracker.entity.Role;
import com.dpx.tracker.mapper.RoleMapper;
import com.dpx.tracker.repository.RoleRepository;
import com.dpx.tracker.service.impl.RoleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class RoleServiceUnitTest {

    @InjectMocks
    private RoleServiceImpl roleService;

    @Mock
    private RoleRepository roleRepository;

    private RoleCreateDto role;

    @BeforeEach
    public void setup() {
        this.role = RoleCreateDto.builder()
                .name("USER_ROLE_TEST")
                .description("User Role Test is a default role for every user account created")
                .build();
    }

    @Test
    void createRoleTest() {
       Role roleEntity = RoleMapper.toEntity(role);
       roleEntity.setId(UUID.randomUUID());

       given(roleRepository.save(any(Role.class))).willReturn(roleEntity);

       RoleResponseDto expectedResult = roleService.createRole(role);

       assertThat(expectedResult).isNotNull();
       assertThat(expectedResult.name()).isEqualTo(role.name());
       assertThat(expectedResult.description()).isEqualTo(role.description());

       verify(roleRepository, times(1)).save(any(Role.class));
    }

    @Test
    void deleteRoleByIdTest() {
        UUID roleId = UUID.randomUUID();
        Role roleEntity = RoleMapper.toEntity(role);
        roleEntity.setId(roleId);

        given(roleRepository.findById(roleId)).willReturn(Optional.of(roleEntity));

        roleService.deleteRoleById(roleId);

        verify(roleRepository, times(1)).delete(roleEntity);
    }

    @Test
    void getRoleByIdTest() {
        UUID roleId = UUID.randomUUID();
        Role roleEntity = RoleMapper.toEntity(role);
        roleEntity.setId(roleId);

        given(roleRepository.findById(roleId)).willReturn(Optional.of(roleEntity));

        RoleResponseDto roleFounded = roleService.getRoleById(roleEntity.getId());

        assertThat(roleFounded).isNotNull();
        assertThat(roleEntity.getName()).isEqualTo(roleFounded.name());
    }

}
