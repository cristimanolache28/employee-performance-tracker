package com.dpx.tracker.controller;

import com.dpx.tracker.constants.EndpointConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = EndpointConstants.SKILL_LEVEL_ENDPOINT, produces = APPLICATION_JSON_VALUE)
public class SkillLevelController {
}
