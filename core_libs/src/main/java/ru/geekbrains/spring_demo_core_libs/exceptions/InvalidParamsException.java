package ru.geekbrains.spring_demo_core_libs.exceptions;

public class InvalidParamsException extends RuntimeException {
    public InvalidParamsException(String message) {
        super(message);
    }
}
