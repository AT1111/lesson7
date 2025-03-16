package com.lesson7.solution.config;

import com.lesson7.solution.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEntityNotFoundException(
        EntityNotFoundException ex) {
        return getStandartTemplateOfResponseEntity(ex, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
        HttpMessageNotReadableException ex,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request
    ) {
        return getStandartTemplateOfResponseEntity(ex, (HttpStatus) status);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleEntity(
        RuntimeException ex) {
        return getStandartTemplateOfResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> getStandartTemplateOfResponseEntity(Throwable e, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), httpStatus,
            List.of(e.getMessage()));
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    private record ErrorResponse(
        LocalDateTime time,
        HttpStatus status,
        List<String> error
    ) {
    }
}
