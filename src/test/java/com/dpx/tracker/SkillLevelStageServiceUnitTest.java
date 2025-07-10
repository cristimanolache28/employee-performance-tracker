package com.dpx.tracker;

import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageCreateDto;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageResponseDto;
import com.dpx.tracker.entity.SkillLevelStage;
import com.dpx.tracker.mapper.SkillLevelStageMapper;
import com.dpx.tracker.repository.SkillLevelStageRepository;
import com.dpx.tracker.service.impl.SkillLevelStageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SkillLevelStageServiceUnitTest {

    @InjectMocks
    private SkillLevelStageServiceImpl slsService;

    @Mock
    private SkillLevelStageRepository repository;

    private SkillLevelStageCreateDto dto;

    @BeforeEach
    public void setup() {
        this.dto = new SkillLevelStageCreateDto(
                "Test",
                "It is just a description made in test",
                10
        );
    }

    @Test
    public void createSkillLevelStageTest() {
        SkillLevelStage entity = SkillLevelStageMapper.toEntity(dto);
        entity.setId(UUID.randomUUID());

        when(repository.save(any(SkillLevelStage.class)))
                .thenReturn(entity);

        SkillLevelStageResponseDto result = slsService.createSkillLevelStage(dto);

        assertThat(result).isNotNull();
        assertThat(result.name()).isEqualTo(dto.name());
        assertThat(result.description()).isEqualTo(dto.description());
    }

}
