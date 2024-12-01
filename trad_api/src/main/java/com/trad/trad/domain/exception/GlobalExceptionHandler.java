package com.trad.trad.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validatedException (MethodArgumentNotValidException exception){
        Map<String,String> messages = new HashMap<>();
        for (FieldError fieldError: exception.getFieldErrors() ){
            messages.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(messages);
    }

    @ExceptionHandler(TradAppException.class)
    public ResponseEntity<TradAppExceptionResponse> tradAppException (TradAppException exception){
        TradAppExceptionResponse response = new TradAppExceptionResponse(
                exception.getMessage(),
                exception.getHttpStatusCode(),
                exception.getCause()
        );
        return new ResponseEntity<>(response, exception.getHttpStatusCode() );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException (MethodArgumentTypeMismatchException exception){
        return new ResponseEntity<>(exception.getMessage() , HttpStatus.BAD_REQUEST);
    }
}
