package com.app.server.controllers.exceptions;

import com.app.server.services.exceptions.OrganizationNotFoundException;
import com.app.server.services.exceptions.UserAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    private ResponseEntity<StandardError> generateStandardError(String error,
                                                                String message,
                                                                HttpServletRequest request,
                                                                HttpStatus status) {
        return ResponseEntity.status(status.value())
                .body(new StandardError(Instant.now(),
                        message,
                        request.getRequestURI(),
                        status.value(),
                        error));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<StandardError> userAlreadyExists(HttpServletRequest request) {
        return generateStandardError("User already exists", "User already exists on database", request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<StandardError> orgNotFound(HttpServletRequest request) {
        return generateStandardError("Organization not found", "Organization not found on database", request, HttpStatus.BAD_REQUEST);
    }
}
