package com.dpx.tracker.exception;

import java.time.Instant;

public record ErrorResponse (
        String errorCode,
        String message,
        int status,
        Instant timestamp,
        String path
)  {

}
