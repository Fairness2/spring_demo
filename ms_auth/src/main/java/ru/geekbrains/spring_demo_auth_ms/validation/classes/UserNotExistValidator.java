package ru.geekbrains.spring_demo_auth_ms.validation.classes;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.spring_demo_auth_ms.repositories.UserRepository;
import ru.geekbrains.spring_demo_auth_ms.validation.interfaces.UserNotExist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Валиадатор для проверки существования пользователя.
 */
public class UserNotExistValidator implements ConstraintValidator<UserNotExist, String> {

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserNotExist userNotExist){}

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return username != null && repository.findByUsername(username).isEmpty();
    }
}
