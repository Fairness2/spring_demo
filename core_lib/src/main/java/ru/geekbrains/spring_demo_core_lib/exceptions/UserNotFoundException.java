package ru.geekbrains.spring_demo_core_lib.exceptions;

/**
 * Ошибка, что пользователь не найден
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
