package com.dpx.tracker.dto.skilllevelstages;


import java.util.UUID;

public record SkillLevelStageResponseDto(
        UUID id,
        String name,
        String description,
        int points

) {
}
