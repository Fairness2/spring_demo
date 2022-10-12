package ru.geekbrains.spring_demo_products_ms.validation.interfaces;

import ru.geekbrains.spring_demo_products_ms.validation.classes.ProductExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Аннотация валиадатора для проверки наличия продукта.
 */
@Documented
@Constraint(validatedBy = ProductExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductExist {
    String message() default "Такого продукта не существует";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
