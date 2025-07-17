package com.BE_13.DevTogether.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionResponse> customRequestException(
        final UserException userException
    ) {
        log.error("user exception : {} ",userException.getMessage(), userException);

        return ResponseEntity.status(userException.getErrorCode().getHttpStatus())
                .body(new ExceptionResponse(
                        userException.getMessage(),
                        userException.getErrorCode()
                ));
    }

    @Getter
    @ToString
    @AllArgsConstructor
    public static class ExceptionResponse {
        private String message;
        private ErrorCode errorCode;
    }
}
