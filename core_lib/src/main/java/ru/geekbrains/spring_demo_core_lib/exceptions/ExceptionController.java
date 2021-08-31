package ru.geekbrains.spring_demo_core_lib.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ProjectError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleInvalidParamsException(InvalidParamsException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ProjectError(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleInvalidParamsException(UsernameNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ProjectError(HttpStatus.UNAUTHORIZED.value(), e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleInvalidParamsException(UserNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ProjectError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleLoginException(LoginException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ProjectError(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
