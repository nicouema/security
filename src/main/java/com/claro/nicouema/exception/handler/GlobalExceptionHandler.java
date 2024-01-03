package com.claro.nicouema.exception.handler;

import com.claro.nicouema.exception.ConflictException;
import com.claro.nicouema.exception.ResourceNotFoundException;
import com.claro.nicouema.exception.error.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public final class GlobalExceptionHandler {

    private static final String RESOURCE_ALREADY_EXISTS = "RESOURCE ALREADY EXISTS";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).toList();


        ErrorDetails errorResponse = ErrorDetails.builder()
                .status(HttpStatus.BAD_REQUEST.toString())
                .description("The body request is invalid")
                .details(errors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFoundException e) {
        log.warn(":::::: {} ::::::", e.getMessage());
        ErrorDetails errorResponse = ErrorDetails.builder()
                .status(HttpStatus.NOT_FOUND.toString())
                .details(Collections.singletonList(e.getMessage()))
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDetails> handleNullPointerException(NullPointerException e) {
        ErrorDetails errorResponse = ErrorDetails.builder()
                .status(INTERNAL_SERVER_ERROR.toString())
                .details(Collections.singletonList(e.getMessage()))
                .build();
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorResponse);
    }


    @ExceptionHandler(ConflictException.class)
    private ResponseEntity<ErrorDetails> handleConflict(ConflictException ex) {

        ErrorDetails error = ErrorDetails.builder()
                .status(RESOURCE_ALREADY_EXISTS)
                .description("The resource already exists in the database")
                .details(Collections.singletonList(ex.getErrorMessage()))
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }


}
