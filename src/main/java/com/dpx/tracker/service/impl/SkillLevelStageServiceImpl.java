package com.dpx.tracker.service.impl;

import com.dpx.tracker.constants.ErrorMessage;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageCreateDto;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageResponseDto;
import com.dpx.tracker.entity.SkillLevelStage;
import com.dpx.tracker.exception.SkillLevelStageException;
import com.dpx.tracker.mapper.SkillLevelStageMapper;
import com.dpx.tracker.repository.SkillLevelStageRepository;
import com.dpx.tracker.service.SkillLevelStageService;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.UUID;

@Service
public class SkillLevelStageServiceImpl implements SkillLevelStageService {

    private SkillLevelStageRepository slsRepository;

    public SkillLevelStageServiceImpl(SkillLevelStageRepository slsRepository) {
        this.slsRepository = slsRepository;
    }

    @Override
    public SkillLevelStageResponseDto createSkillLevelStage(SkillLevelStageCreateDto dto) {
        Objects.requireNonNull(dto, ErrorMessage.SKILL_LEVEL_STAGE_DTO_NULL);
        SkillLevelStage skillLevelStage = SkillLevelStageMapper.toEntity(dto);
        SkillLevelStage slsSaved = slsRepository.save(skillLevelStage);
        return SkillLevelStageMapper.toDto(slsSaved);
    }

    @Override
    public SkillLevelStageResponseDto getSkillLevelStageById(UUID id) {
        SkillLevelStage slsEntity = slsRepository.findById(id)
                .orElseThrow(() -> new SkillLevelStageException(MessageFormat.format(ErrorMessage.SKILL_LEVEL_STAGE_ID_NULL, id)));
        return SkillLevelStageMapper.toDto(slsEntity);

    }
}
