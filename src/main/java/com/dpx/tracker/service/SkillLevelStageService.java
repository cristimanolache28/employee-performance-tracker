package com.dpx.tracker.service;

import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageCreateDto;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageResponseDto;

public interface SkillLevelStageService {

    SkillLevelStageResponseDto createSkillLevelStage(SkillLevelStageCreateDto dto);
}
