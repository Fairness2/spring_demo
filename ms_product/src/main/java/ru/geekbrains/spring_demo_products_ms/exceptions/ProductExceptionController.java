package ru.geekbrains.spring_demo_products_ms.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.geekbrains.spring_demo_core_lib.exceptions.ProjectError;

@ControllerAdvice
@Slf4j
public class ProductExceptionController {
    /**
     * Продукт не найден
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ProjectError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
