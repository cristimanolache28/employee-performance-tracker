package com.dpx.tracker.service;

import com.dpx.tracker.dto.skilllevel.SkillLevelCreateDto;
import com.dpx.tracker.dto.skilllevel.SkillLevelDeleteDto;
import com.dpx.tracker.dto.skilllevel.SkillLevelResponseDto;
import com.dpx.tracker.dto.skilllevel.SkillLevelUpdateDto;

import java.util.List;
import java.util.UUID;

public interface SkillLevelService {
    SkillLevelResponseDto createSkillLevel(SkillLevelCreateDto skillCreateDto, UUID skillStageId);

    SkillLevelResponseDto getSkillLevelById(UUID id);

    public SkillLevelUpdateDto updateSkillLevelById(UUID id, SkillLevelUpdateDto dto);

}
