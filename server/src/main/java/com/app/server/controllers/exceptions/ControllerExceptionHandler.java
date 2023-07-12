package com.app.server.controllers.exceptions;

import com.app.server.services.exceptions.UserAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    private ResponseEntity<StandardError> generateStandardError(String error,
                                                                RuntimeException e,
                                                                HttpServletRequest request,
                                                                HttpStatus status) {
        return ResponseEntity.status(status.value())
                .body(new StandardError(Instant.now(),
                        e.getMessage(),
                        request.getRequestURI(),
                        status.value(),
                        error));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<StandardError> userAlreadyExists(UserAlreadyExistsException e, HttpServletRequest request) {
        return generateStandardError("User already exists", e, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<StandardError> usernameNotFound(UsernameNotFoundException e, HttpServletRequest request) {
        return generateStandardError("User not found", e, request, HttpStatus.BAD_REQUEST);
    }
}
