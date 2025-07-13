package com.dpx.tracker.controller;

import com.dpx.tracker.constants.EndpointConstants;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageCreateDto;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageDeleteResponse;
import com.dpx.tracker.dto.skilllevelstages.SkillLevelStageResponseDto;
import com.dpx.tracker.service.SkillLevelStageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = EndpointConstants.SKILL_LEVEL_STAGE_ENDPOINT,  produces = APPLICATION_JSON_VALUE)
public class SkillLevelStageController {
    private final SkillLevelStageService service;

    public SkillLevelStageController(SkillLevelStageService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillLevelStageResponseDto> getSkillLevelStageById(@PathVariable UUID id) {
        return ResponseEntity
                .ok()
                .body(service.getSkillLevelStageById(id));
    }

    @GetMapping()
    public ResponseEntity<List<SkillLevelStageResponseDto>> getSkillLevelStageById() {
        return ResponseEntity
                .ok()
                .body(service.getAllSkillLevelStages());
    }

    @PostMapping
    public ResponseEntity<SkillLevelStageResponseDto> createSkillLevelStage(@RequestBody @Valid SkillLevelStageCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createSkillLevelStage(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SkillLevelStageDeleteResponse> deleteSkillLevelStageById(@PathVariable UUID id) {
        return ResponseEntity
                .ok()
                .body(service.deleteSkillLevelStageById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillLevelStageResponseDto> updateSkillLevelStageById(@PathVariable UUID id, SkillLevelStageCreateDto dto) {
        return ResponseEntity
                .ok()
                .body(service.updateSkillLevelStageById(id, dto));
    }

}
