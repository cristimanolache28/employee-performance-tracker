package com.dpx.tracker.exception;

import com.dpx.tracker.constants.ErrorMessage;

public class SkillLevelNotFoundException extends ResourceNotFoundException {
    public SkillLevelNotFoundException(String message) {
        super(message, ErrorMessage.SKILL_LEVEL_ID_NULL);
    }
}
