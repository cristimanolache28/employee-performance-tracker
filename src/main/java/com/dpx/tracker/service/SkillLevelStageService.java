package com.dpx.tracker.service;

import com.dpx.tracker.dto.skilllevelstages.DeleteSkillLevelStageResponse;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageCreateDto;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageResponseDto;
import com.dpx.tracker.entity.Skill;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface SkillLevelStageService {

    SkillLevelStageResponseDto createSkillLevelStage(SkillLevelStageCreateDto dto);

    SkillLevelStageResponseDto getSkillLevelStageById(UUID id);

    DeleteSkillLevelStageResponse deleteSkillLevelStageById(UUID id);

    List<SkillLevelStageResponseDto> getAllSkillLevelStages();

    SkillLevelStageResponseDto updateSkillLevelStageById(UUID id, SkillLevelStageCreateDto dto);

}
