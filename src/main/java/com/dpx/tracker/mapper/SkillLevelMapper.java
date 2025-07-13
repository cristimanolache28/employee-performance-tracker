package com.dpx.tracker.mapper;

import com.dpx.tracker.dto.skilllevel.SkillLevelCreateDto;
import com.dpx.tracker.dto.skilllevel.SkillLevelResponseDto;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageLiteDto;
import com.dpx.tracker.entity.SkillLevel;
import com.dpx.tracker.entity.SkillLevelStage;

public final class SkillLevelMapper {

    public SkillLevelMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static SkillLevel toEntity(SkillLevelCreateDto dto, SkillLevelStage stage) {
        SkillLevel skillLevel = new SkillLevel();
        skillLevel.setName(dto.name());
        skillLevel.setDescription(dto.description());
        skillLevel.setPoints(dto.points());
        skillLevel.setSkillLevelStage(stage);
        return skillLevel;
    }

    public static SkillLevelResponseDto toDto(SkillLevel skillLevel) {
        SkillLevelStage stage = skillLevel.getSkillLevelStage();

        SkillLevelStageLiteDto stageLiteDto = new SkillLevelStageLiteDto(
                stage.getName(),
                stage.getPoints()
        );

        return  new SkillLevelResponseDto(
                skillLevel.getId(),
                skillLevel.getName(),
                skillLevel.getDescription(),
                skillLevel.getPoints(),
                stageLiteDto
        );
    }

}
