package com.giovanni.transferencias.backend.exception;

import java.time.OffsetDateTime;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ApiError> handle422(NegocioException ex, HttpServletRequest req) {
        ApiError body = new ApiError(OffsetDateTime.now(), 422, "Unprocessable Entity", ex.getMessage(),
                req.getRequestURI());
        return ResponseEntity.status(422).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handle400(MethodArgumentNotValidException ex, HttpServletRequest req) {
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                .collect(Collectors.joining("; "));
        ApiError body = new ApiError(OffsetDateTime.now(), 400, "Bad Request", msg, req.getRequestURI());
        return ResponseEntity.badRequest().body(body);
    }
}
