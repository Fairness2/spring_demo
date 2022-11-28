package ru.geekbrains.sring_demo_order_ms.validation.interfaces;

import ru.geekbrains.sring_demo_order_ms.validation.classes.StatusExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Аннотация валиадатора для проверки наличия статуса заказа.
 */
@Documented
@Constraint(validatedBy = StatusExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StatusExist {
    String message() default "Такого статуса не существует";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
