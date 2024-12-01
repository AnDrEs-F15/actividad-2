package com.trad.trad.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class TradAppExceptionResponse {
    private String message;
    private HttpStatus httpStatusCode;
    private Throwable cause;
}
