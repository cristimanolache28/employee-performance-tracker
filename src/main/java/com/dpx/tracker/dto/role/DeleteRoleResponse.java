package com.dpx.tracker.dto.role;

import java.time.Instant;
import java.util.UUID;

public record DeleteRoleResponse(
        String message,
        UUID id,
        Instant timestamp
) {
}
