package ru.geekbrains.spring_demo_core_lib.validation.classes;

import org.springframework.beans.BeanWrapperImpl;
import ru.geekbrains.spring_demo_core_lib.validation.intefaces.GreaterOrEqualsThan;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Валиадатор для проверки что одно поле больше или равно другому.
 */
public class GreaterOrEqualsThenValidator implements ConstraintValidator<GreaterOrEqualsThan, Object> {

    private String field;
    private String secondField;

    @Override
    public void initialize(GreaterOrEqualsThan greaterOrEqualsThan){
        this.field = greaterOrEqualsThan.field();
        this.secondField = greaterOrEqualsThan.secondField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Object value = new BeanWrapperImpl(object).getPropertyValue(this.field);
        Object secondValue = new BeanWrapperImpl(object).getPropertyValue(this.secondField);
        if (value == null || secondValue == null) {
            // Если одно из значений не указано, то считаем, что проверка выполнена
            return true;
        }
        if (!(value instanceof Number) || !(secondValue instanceof Number) ) {
            //throw new  NumberFormatException("Значения не являются числами");
            return false;
        }

        double dValue = ((Number) value).doubleValue();
        double dSecondValue = ((Number) secondValue).doubleValue();

        return dValue >= dSecondValue;
    }
}
