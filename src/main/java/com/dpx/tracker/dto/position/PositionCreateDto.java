package com.dpx.tracker.dto.position;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PositionCreateDto(
        @NotBlank String name,
        @NotBlank String description,
        @NotNull UUID departmentId
) {

}
