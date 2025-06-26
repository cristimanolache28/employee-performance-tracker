package com.dpx.tracker.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(
                e.getErrorCode(),
                e.getMessage(),
                e.getStatus().value(),
                Instant.now(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(response, e.getStatus());
    }

}
