package com.dpx.tracker.mapper;

import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageCreateDto;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageResponseDto;
import com.dpx.tracker.entity.SkillLevelStage;

public final class SkillLevelStageMapper {

    public SkillLevelStageMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static SkillLevelStage toEntity(SkillLevelStageCreateDto dto) {
        if (dto == null) {
            return null;
        }

        SkillLevelStage skillLevelStage = new SkillLevelStage();
        skillLevelStage.setName(dto.name());
        skillLevelStage.setDescription(dto.description());
        skillLevelStage.setPoints(dto.points());
        return skillLevelStage;
    }

    public static SkillLevelStageResponseDto toDto(SkillLevelStage skillLevelStage) {
        if (skillLevelStage == null) {
            return null;
        }

        return new SkillLevelStageResponseDto(
                skillLevelStage.getId(),
                skillLevelStage.getName(),
                skillLevelStage.getDescription(),
                skillLevelStage.getPoints()
        );
    }

}
