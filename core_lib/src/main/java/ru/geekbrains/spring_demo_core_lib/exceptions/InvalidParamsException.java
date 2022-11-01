package ru.geekbrains.spring_demo_core_lib.exceptions;

/**
 * Ошибка неверно переданных параметров
 */
public class InvalidParamsException extends RuntimeException {
    public InvalidParamsException(String message) {
        super(message);
    }
}
