package com.dpx.tracker;

import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;
import com.dpx.tracker.entity.Role;
import com.dpx.tracker.exception.RoleNotFoundException;
import com.dpx.tracker.repository.RoleRepository;
import com.dpx.tracker.service.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;


@SpringBootTest
@Transactional
@Rollback
public class RoleServiceIntegrationTest {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    void clearDatabase() {
        roleRepository.deleteAll();
    }

    @Test
    void testFindAllRoles() {
        RoleCreateDto admin = new RoleCreateDto("ADMIN_TEST", "The ADMIN ran can do anything request and it is only role cand use delete function.");
        RoleCreateDto moderator = new RoleCreateDto("MODERATOR_TEST", "The MODERATOR can do: get roles, update roles and create roles. It can not delete.");
        RoleCreateDto user = new RoleCreateDto("USER_TEST", "The USER role is a default role for every user created.");

        roleService.createRole(admin);
        roleService.createRole(moderator);
        roleService.createRole(user);

        List<RoleResponseDto> roles = roleService.getAllRoles();

        List<String> roleNames = roles.stream().map(RoleResponseDto::name).toList();
        assertThat(roleNames).containsExactlyInAnyOrder("ADMIN_TEST", "MODERATOR_TEST", "USER_TEST");

        assertThat(roles).hasSize(3);
    }

    @Test
    void testCreateRole(){
        RoleCreateDto roleCreateDto = new RoleCreateDto("ADMIN_TEST", "The ADMIN ran can do anything request and it is only role cand use delete function.");
        RoleResponseDto savedRole = roleService.createRole(roleCreateDto);

        String expectedRoleName = roleCreateDto.name();
        String expectedDescriptionRole = roleCreateDto.description();

        assertEquals(expectedRoleName, savedRole.name());
        assertEquals(expectedDescriptionRole, savedRole.description());

        assertThat(savedRole.id()).isNotNull();
    }

    @Test
    void testDeleteRole() {
        RoleCreateDto userRole = new RoleCreateDto("USER_TEST", "The USER role is a default role for every user created.");
        RoleResponseDto role = roleService.createRole(userRole);

        roleService.deleteRoleById(role.id());

        assertThrows(RoleNotFoundException.class, () -> roleService.getRoleById(role.id()));
    }

    @Test
    void testDeleteRoleWithInvalidId() {
        UUID id = UUID.randomUUID();
        assertThrows(RoleNotFoundException.class, () -> roleService.deleteRoleById(id));
    }

    @Test
    void testUpdateRole() {
        Role role = new Role();
        role.setName("USER_ROLE");
        role.setDescription("The USER_ROLE role is a default role for every user created.");
        roleRepository.save(role);

        RoleCreateDto updateRole = new RoleCreateDto("USER_ROLE_UPDATE", "The USER_ROLE role is a default role for every user created. - UPDATE");
        roleService.updateRoleById(role.getId(), updateRole);

        RoleResponseDto updateRoleResponse = roleService.getRoleById(role.getId());

        assertEquals(updateRole.name(), updateRoleResponse.name());
        assertEquals(updateRole.description(), updateRoleResponse.description());
    }

    @Test
    void testUpdateRoleWithInvalidId() {
        UUID id = UUID.randomUUID();
        RoleCreateDto userRole = new RoleCreateDto("USER_TEST", "The USER role is a default role for every user created.");
        assertThrows(RoleNotFoundException.class, () -> roleService.updateRoleById(id, userRole));
    }

}
