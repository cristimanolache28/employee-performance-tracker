package com.dpx.tracker.controller;

import com.dpx.tracker.constants.EndpointConstants;
import com.dpx.tracker.constants.ErrorMessage;
import com.dpx.tracker.constants.Messages;
import com.dpx.tracker.dto.skilllevel.SkillLevelCreateDto;
import com.dpx.tracker.dto.skilllevel.SkillLevelDeleteDto;
import com.dpx.tracker.dto.skilllevel.SkillLevelResponseDto;
import com.dpx.tracker.dto.skilllevel.SkillLevelUpdateDto;
import com.dpx.tracker.entity.SkillLevel;
import com.dpx.tracker.exception.SkillLevelNotFoundException;
import com.dpx.tracker.mapper.SkillLevelMapper;
import com.dpx.tracker.service.SkillLevelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = EndpointConstants.SKILL_LEVEL_ENDPOINT, produces = APPLICATION_JSON_VALUE)
public class SkillLevelController {

    private final SkillLevelService skillService;

    public SkillLevelController(SkillLevelService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<SkillLevelResponseDto> createSkillLevel(@RequestBody @Valid SkillLevelCreateDto dto, UUID stageId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(skillService.createSkillLevel(dto, stageId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillLevelResponseDto> getSkillLevelById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity
                .ok()
                .body(skillService.getSkillLevelById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillLevelUpdateDto> updateSkillLevelById(@PathVariable(value = "id") UUID id,
                                                                      @RequestBody @Valid SkillLevelUpdateDto dto) {
        return ResponseEntity
                .ok()
                .body(skillService.updateSkillLevelById(id, dto));
    }
}
