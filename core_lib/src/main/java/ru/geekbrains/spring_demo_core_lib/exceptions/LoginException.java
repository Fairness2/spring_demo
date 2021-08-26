package ru.geekbrains.spring_demo_core_lib.exceptions;

public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }
}
