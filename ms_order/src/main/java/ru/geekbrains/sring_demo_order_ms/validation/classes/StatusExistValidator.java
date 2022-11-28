package ru.geekbrains.sring_demo_order_ms.validation.classes;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.sring_demo_order_ms.repositories.StatusRepository;
import ru.geekbrains.sring_demo_order_ms.validation.interfaces.StatusExist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Валиадатор для проверки наличия статуса.
 */
public class StatusExistValidator implements ConstraintValidator<StatusExist, String> {

    @Autowired
    private StatusRepository repository;

    @Override
    public void initialize(StatusExist statusExist){}

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        return code == null || repository.existsById(code);
    }
}
