package ru.geekbrains.spring_demo_core_lib.validation.intefaces;

import ru.geekbrains.spring_demo_core_lib.validation.classes.DateFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Аннотация валиадатора для проверки наличия такой категории.
 */
@Documented
@Constraint(validatedBy = DateFormatValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFormat {
    String message() default "Дата не соответствует формату";
    String format() default "yyyy-MM-dd";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
