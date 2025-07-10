package com.dpx.tracker.exception;

import com.dpx.tracker.constants.ErrorCodes;

public class SkillLevelStageException extends ResourceNotFoundException {
    public SkillLevelStageException(String message) {
        super(message, ErrorCodes.SKILL_LEVEL_STAGE_NOT_FOUND);
    }


}
