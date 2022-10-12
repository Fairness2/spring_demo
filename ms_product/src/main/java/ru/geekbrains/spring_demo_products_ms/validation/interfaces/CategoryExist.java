package ru.geekbrains.spring_demo_products_ms.validation.interfaces;

import ru.geekbrains.spring_demo_products_ms.validation.classes.CategoryExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Аннотация валиадатора для проверки наличия такой категории.
 */
@Documented
@Constraint(validatedBy = CategoryExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryExist {
    String message() default "Такой категории не существует";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
