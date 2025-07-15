package com.dpx.tracker.controller;

import com.dpx.tracker.constants.EndpointConstants;
import com.dpx.tracker.dto.skilllevel.SkillLevelCreateDto;
import com.dpx.tracker.dto.skilllevel.SkillLevelResponseDto;
import com.dpx.tracker.service.SkillLevelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
