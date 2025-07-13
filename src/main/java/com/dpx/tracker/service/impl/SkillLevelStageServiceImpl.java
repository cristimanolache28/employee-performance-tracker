package com.dpx.tracker.service.impl;

import com.dpx.tracker.constants.ErrorMessage;
import com.dpx.tracker.constants.Messages;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageDeleteResponse;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageCreateDto;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageResponseDto;
import com.dpx.tracker.entity.SkillLevelStage;
import com.dpx.tracker.exception.SkillLevelStageNotFoundException;
import com.dpx.tracker.mapper.SkillLevelStageMapper;
import com.dpx.tracker.repository.SkillLevelStageRepository;
import com.dpx.tracker.service.SkillLevelStageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class SkillLevelStageServiceImpl implements SkillLevelStageService {

    private final SkillLevelStageRepository slsRepository;

    public SkillLevelStageServiceImpl(SkillLevelStageRepository slsRepository) {
        this.slsRepository = slsRepository;
    }

    @Override
    public SkillLevelStageResponseDto createSkillLevelStage(SkillLevelStageCreateDto dto) {
        Objects.requireNonNull(dto, ErrorMessage.SKILL_LEVEL_STAGE_DTO_NULL);
        SkillLevelStage skillLevelStage = SkillLevelStageMapper.toEntity(dto);
        SkillLevelStage slsSaved = slsRepository.save(skillLevelStage);
        log.info("Creating SkillLevelStage with name: {}", dto.name());
        return SkillLevelStageMapper.toDto(slsSaved);
    }

    @Override
    public SkillLevelStageResponseDto getSkillLevelStageById(UUID id) {
        SkillLevelStage slsEntity = slsRepository.findById(id)
                .orElseThrow(() -> new SkillLevelStageNotFoundException(
                        String.format(ErrorMessage.SKILL_LEVEL_STAGE_ID_NULL, id)));
        log.info("Fetching SkillLevelStage by ID: {}", id);
        return SkillLevelStageMapper.toDto(slsEntity);
    }

    @Override
    public SkillLevelStageDeleteResponse deleteSkillLevelStageById(UUID id) {
        SkillLevelStage slsEntity = slsRepository.findById(id)
                .orElseThrow(() -> new SkillLevelStageNotFoundException(
                        String.format(ErrorMessage.SKILL_LEVEL_STAGE_ID_NULL, id)));
        slsRepository.delete(slsEntity);

        log.info(Messages.SKILL_LEVEL_STAGE_DELETED);
        return new SkillLevelStageDeleteResponse(Messages.SKILL_LEVEL_STAGE_DELETED, id, Instant.now());
    }

    @Override
    public List<SkillLevelStageResponseDto> getAllSkillLevelStages() {
        List<SkillLevelStage> slsList = slsRepository.findAll();
        if (slsList.isEmpty()) {
            log.warn("No SkillLevelStage found.");
            return  List.of();
        }
        return slsList.stream()
                .map(SkillLevelStageMapper::toDto)
                .toList();
    }

    @Override
    public SkillLevelStageResponseDto updateSkillLevelStageById(UUID id, SkillLevelStageCreateDto dto) {
        SkillLevelStage skillLevelStage = slsRepository.findById(id)
                .orElseThrow(() -> new SkillLevelStageNotFoundException(String.format(ErrorMessage.SKILL_LEVEL_STAGE_ID_NULL, id)));

        skillLevelStage.setName(dto.name());
        skillLevelStage.setDescription(dto.description());
        skillLevelStage.setPoints(dto.points());

        slsRepository.save(skillLevelStage);

        return SkillLevelStageMapper.toDto(skillLevelStage);
    }
}
