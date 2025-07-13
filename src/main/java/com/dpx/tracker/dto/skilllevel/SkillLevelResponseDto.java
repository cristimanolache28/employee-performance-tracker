package com.dpx.tracker.dto.skilllevel;

import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageLiteDto;

import java.util.UUID;

public record SkillLevelResponseDto(
    UUID id,
    String name,
    String description,
    int points,
    SkillLevelStageLiteDto skillLevelStageLiteDto
) {
}
