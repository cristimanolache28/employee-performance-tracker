package com.dpx.tracker.dto.skilllevel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record SkillLevelCreateDto(
    @NotBlank String name,
    @Size(min = 10, max = 50) String description,
    @NotNull @Min(10) int points,
    @NotNull UUID skillLevelStageId
) {
}
