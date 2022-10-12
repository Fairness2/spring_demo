package ru.geekbrains.spring_demo_products_ms.validation.interfaces;

import ru.geekbrains.spring_demo_products_ms.validation.classes.ProductListExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Аннотация валиадатора для проверки наличия всег осписка продуктов.
 */
@Documented
@Constraint(validatedBy = ProductListExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductListExist {
    String message() default "Таких продуктов не существует";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
