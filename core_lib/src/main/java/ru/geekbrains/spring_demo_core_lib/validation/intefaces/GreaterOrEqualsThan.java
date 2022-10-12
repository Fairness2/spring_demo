package ru.geekbrains.spring_demo_core_lib.validation.intefaces;

import ru.geekbrains.spring_demo_core_lib.validation.classes.GreaterOrEqualsThenValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = GreaterOrEqualsThenValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface GreaterOrEqualsThan {
    String message() default "Число меньше, чем второе";
    String field();
    String secondField();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        GreaterOrEqualsThan[] value();
    }
}
