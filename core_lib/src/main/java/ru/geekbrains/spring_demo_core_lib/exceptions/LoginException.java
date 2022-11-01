package ru.geekbrains.spring_demo_core_lib.exceptions;

/**
 * Ошибка входа
 */
public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }
}
