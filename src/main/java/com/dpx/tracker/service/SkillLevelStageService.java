package com.dpx.tracker.service;

import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageDeleteResponse;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageCreateDto;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageResponseDto;

import java.util.List;
import java.util.UUID;

public interface SkillLevelStageService {

    SkillLevelStageResponseDto createSkillLevelStage(SkillLevelStageCreateDto dto);

    SkillLevelStageResponseDto getSkillLevelStageById(UUID id);

    SkillLevelStageDeleteResponse deleteSkillLevelStageById(UUID id);

    List<SkillLevelStageResponseDto> getAllSkillLevelStages();

    SkillLevelStageResponseDto updateSkillLevelStageById(UUID id, SkillLevelStageCreateDto dto);

}
