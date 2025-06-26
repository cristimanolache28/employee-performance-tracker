package com.dpx.tracker.controller;

import com.dpx.tracker.dto.role.DeleteRoleResponse;
import com.dpx.tracker.dto.role.RoleCreateDto;
import com.dpx.tracker.dto.role.RoleResponseDto;
import com.dpx.tracker.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleCreateDto createDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(APPLICATION_JSON)
                .body(roleService.createRole(createDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> getRoleById(@PathVariable(name = "id") UUID id) {
        return ResponseEntity
                .ok()
                .contentType(APPLICATION_JSON)
                .body(roleService.getRoleById(id));
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getAllRoles() {
        return ResponseEntity
                .ok()
                .contentType(APPLICATION_JSON)
                .body(roleService.getAllRoles());
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<DeleteRoleResponse> deleteRoleById(UUID id) {
        return ResponseEntity
                .ok()
                .contentType(APPLICATION_JSON)
                .body(roleService.deleteRoleById(id));
    }

}
