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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.AbstractPersistable_;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

    @Test
    public void getSkillLevelStageByIdTest() {
        UUID slsId = UUID.randomUUID();
        SkillLevelStage entity = SkillLevelStageMapper.toEntity(dto);
        entity.setId(slsId);

        given(repository.findById(slsId)).willReturn(Optional.of(entity));

        SkillLevelStageResponseDto responseDto = slsService.getSkillLevelStageById(entity.getId());

        assertThat(responseDto).isNotNull();
        assertThat(responseDto.name()).isEqualTo(entity.getName());
    }

    @Test
    public void updateSkillLevelStageByIdTest() {
        UUID id = UUID.randomUUID();
        SkillLevelStage originalDto = SkillLevelStageMapper.toEntity(dto);
        originalDto.setId(id);

        SkillLevelStageCreateDto dtoAfterUpdate = new SkillLevelStageCreateDto(
                "Test Update",
                "It is just a description made in test - Update",
                100
        );

        when(repository.findById(id)).thenReturn(Optional.of(originalDto));
        when(repository.save(any(SkillLevelStage.class))).thenAnswer(inv -> inv.getArgument(0));

        SkillLevelStageResponseDto result = slsService.updateSkillLevelStageById(id, dtoAfterUpdate);

        ArgumentCaptor<SkillLevelStage> captor = ArgumentCaptor.forClass(SkillLevelStage.class);
        verify(repository).save(captor.capture());

        SkillLevelStage saved = captor.getValue();
        assertThat(saved.getName()).isEqualTo("Test Update");
        assertThat(saved.getDescription()).contains("Update");
        assertThat(saved.getPoints()).isEqualTo(100);

    }

}
