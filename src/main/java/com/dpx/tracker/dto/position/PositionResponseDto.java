package com.dpx.tracker.dto.position;

import com.dpx.tracker.entity.Department;

import java.util.UUID;

public record PositionResponseDto (
        UUID id,
        String name,
        String description,
        Department department
) {
}
