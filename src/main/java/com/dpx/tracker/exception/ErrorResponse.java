package com.dpx.tracker.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse  {
    private String errorCode;
    private String message;
    private int status;
    private Instant timestamp;
    private String path;
}
