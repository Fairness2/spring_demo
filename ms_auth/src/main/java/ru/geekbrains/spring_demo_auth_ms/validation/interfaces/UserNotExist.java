package ru.geekbrains.spring_demo_auth_ms.validation.interfaces;

import ru.geekbrains.spring_demo_auth_ms.validation.classes.UserNotExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Аннотация валиадатора для проверки существования пользователя.
 */
@Documented
@Constraint(validatedBy = UserNotExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserNotExist {
    String message() default "Пользователь уже существует";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
