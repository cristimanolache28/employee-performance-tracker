package com.dpx.tracker.service;

import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageCreateDto;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageResponseDto;

import java.util.UUID;

public interface SkillLevelStageService {

    SkillLevelStageResponseDto createSkillLevelStage(SkillLevelStageCreateDto dto);

    SkillLevelStageResponseDto getSkillLevelStageById(UUID id);

}
