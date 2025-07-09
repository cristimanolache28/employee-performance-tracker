package com.dpx.tracker.exception;

import org.springframework.http.HttpStatus;

public class SkillLevelStageException extends BaseException {
    public SkillLevelStageException(String message, String errorCode, HttpStatus status) {
        super(message, errorCode, status);
    }
}
