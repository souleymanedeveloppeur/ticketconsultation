package com.medical.exception;

import com.medical.model.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Custom exception class for handling API errors.
 * This class extends ErrorResponseException and provides specific exceptions
 * for common HTTP error statuses such as Bad Request, Not Found, Unauthorized,
 * and Forbidden.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalArgument(IllegalArgumentException exception, HttpServletRequest request) {
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(false)
                .message("Invalid Request: " + exception.getMessage())
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalState(IllegalStateException exception, HttpServletRequest request) {
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(false)
                .message("Operation Conflict: " + exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({AuthenticationException.class, BadCredentialsException.class})
    public ResponseEntity<ApiResponse<String>> handleAuthentication(Exception exception, HttpServletRequest request) {
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(false)
                .message("Authentication Failed: " + exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<String>> handleAccessDenied(AccessDeniedException exception, HttpServletRequest request) {
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(false)
                .message("Access Denied: " + exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleInternalError(Exception exception, HttpServletRequest request) {
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(false)
                .message("Internal Server Error: " + exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleEntityNotFound(EntityNotFoundException exception, HttpServletRequest request) {
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(false)
                .message("Resource non trouvée: " + exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleUsernameNotFound(UsernameNotFoundException exception, HttpServletRequest request) {
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(false)
                .message("Resource Not Found: " + exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<String>> handleDataIntegrityViolation(DataIntegrityViolationException exception, HttpServletRequest request) {
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(false)
                .message("Data Integrity Violation: " + exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ApiResponse<Map<String, String>> response = ApiResponse.<Map<String, String>>builder()
                .success(false)
                .message("Validation failed")
                .data(errors)
                .build();

        return ResponseEntity.badRequest().body(response);
    }
}
