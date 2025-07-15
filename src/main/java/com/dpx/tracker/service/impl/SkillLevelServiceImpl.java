package com.dpx.tracker.service.impl;

import com.dpx.tracker.constants.ErrorMessage;
import com.dpx.tracker.constants.Messages;
import com.dpx.tracker.dto.skilllevel.SkillLevelCreateDto;
import com.dpx.tracker.dto.skilllevel.SkillLevelDeleteDto;
import com.dpx.tracker.dto.skilllevel.SkillLevelResponseDto;
import com.dpx.tracker.entity.SkillLevel;
import com.dpx.tracker.entity.SkillLevelStage;
import com.dpx.tracker.exception.SkillLevelStageNotFoundException;
import com.dpx.tracker.mapper.SkillLevelMapper;
import com.dpx.tracker.repository.SkillLevelRepository;
import com.dpx.tracker.repository.SkillLevelStageRepository;
import com.dpx.tracker.service.SkillLevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SkillLevelServiceImpl implements SkillLevelService {

    private final SkillLevelRepository skillRepository;

    private final SkillLevelStageRepository stageRepository;

    public SkillLevelServiceImpl(SkillLevelRepository skillRepository, SkillLevelStageRepository stageRepository) {
        this.skillRepository = skillRepository;
        this.stageRepository = stageRepository;
    }

    @Override
    public SkillLevelResponseDto createSkillLevel(SkillLevelCreateDto skillCreateDto, UUID skillStageId) {
        SkillLevelStage skillLevelStage = stageRepository.findById(skillStageId)
                .orElseThrow(() -> new SkillLevelStageNotFoundException(String.format(ErrorMessage.SKILL_LEVEL_STAGE_ID_NULL, skillStageId)));

        SkillLevel skillLevel = SkillLevelMapper.toEntity(skillCreateDto, skillLevelStage);
        skillRepository.save(skillLevel);
        log.info("SkillLevel with id {} was created with successfully.", skillLevel.getId());
        return SkillLevelMapper.toDto(skillLevel);

    }

    @Override
    public SkillLevelResponseDto getSkillLevelById(UUID id) {
        return null;
    }

    @Override
    public SkillLevelResponseDto updateSkillLevelById(UUID id, SkillLevelCreateDto dto) {
        return null;
    }

    @Override
    public SkillLevelDeleteDto deleteSkillLevelById(UUID id) {
        return null;
    }

    @Override
    public List<SkillLevelResponseDto> getAllSkillLevels() {
        return List.of();
    }
}
