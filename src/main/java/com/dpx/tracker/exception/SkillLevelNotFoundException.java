package com.dpx.tracker.exception;

public class SkillLevelNotFoundException extends ResourceNotFoundException {
    public SkillLevelNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }
}
