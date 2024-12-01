package com.trad.trad.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class TradAppException extends RuntimeException {
    private HttpStatus httpStatusCode;
   // private Throwable cause;
    public TradAppException(String message,HttpStatus httpStatusCode ) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }
}
