package com.dpx.tracker.controller;

import com.dpx.tracker.constants.EndpointConstants;
import com.dpx.tracker.dto.role.DeleteRoleResponse;
import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;
import com.dpx.tracker.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = EndpointConstants.ROLE_ENDPOINT, produces = APPLICATION_JSON_VALUE)
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleCreateDto createDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(roleService.createRole(createDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> getRoleById(@PathVariable UUID id) {
        return ResponseEntity
                .ok()
                .body(roleService.getRoleById(id));
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getAllRoles() {
        return ResponseEntity
                .ok()
                .body(roleService.getAllRoles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRoleResponse> deleteRoleById(@PathVariable UUID id) {
        return ResponseEntity
                .ok()
                .body(roleService.deleteRoleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDto> updateRoleById(@PathVariable UUID id,
                                                          @RequestBody RoleCreateDto roleCreateDto) {
        return ResponseEntity
                .ok()
                .body(roleService.updateRoleById(id, roleCreateDto));
    }

}
