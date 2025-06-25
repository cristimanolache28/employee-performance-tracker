package com.dpx.tracker.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(force = true)
@Data
public class NotResourceFoundException extends RuntimeException {
    private String errorCode;
    private HttpStatus status;

    public NotResourceFoundException(String errorMessage, String errorCode, HttpStatus status) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.status = status;
    }

    public NotResourceFoundException(String errorMessage) {
        super(errorMessage);
    }


    public NotResourceFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
