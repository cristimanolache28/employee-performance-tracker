package com.dpx.tracker.exception;

import com.dpx.tracker.constants.ErrorCodes;

public class PositionNotFoundException extends ResourceNotFoundException {
    public PositionNotFoundException(String message) {
        super(message, ErrorCodes.POSITION_NOT_FOUND);
    }
}
