package com.dpx.tracker.dto.role;

import java.util.UUID;

public record RoleResponseDto(
    UUID id,
    String role
) {

}
