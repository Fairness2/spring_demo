package ru.geekbrains.spring_demo_products_ms.validation.interfaces;

import ru.geekbrains.spring_demo_products_ms.validation.classes.CategoryListExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Аннотация валиадатора для проверки наличия всего списка категорий.
 */
@Documented
@Constraint(validatedBy = CategoryListExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryListExist {
    String message() default "Таких категорий не существует";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
