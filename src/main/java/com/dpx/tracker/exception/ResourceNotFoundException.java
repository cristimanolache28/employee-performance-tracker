package com.dpx.tracker.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(force = true)
@Data
public class ResourceNotFoundException extends RuntimeException {
    private  String errorCode;
    private  HttpStatus status;

    public ResourceNotFoundException(String errorMessage, String errorCode, HttpStatus status) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.status = status;
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
