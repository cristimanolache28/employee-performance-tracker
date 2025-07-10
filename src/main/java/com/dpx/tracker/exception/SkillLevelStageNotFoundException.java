package com.dpx.tracker.exception;

import com.dpx.tracker.constants.ErrorCodes;

public class SkillLevelStageNotFoundException extends ResourceNotFoundException {
    public SkillLevelStageNotFoundException(String message) {
        super(message, ErrorCodes.SKILL_LEVEL_STAGE_NOT_FOUND);
    }


}
