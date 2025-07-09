package com.dpx.tracker.exception;

import org.springframework.http.HttpStatus;

public class PositionNotFoundException extends BaseException {
    public PositionNotFoundException(String message, String errorCode, HttpStatus status) {
        super(message, errorCode, status);
    }
}
