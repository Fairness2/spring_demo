package ru.geekbrains.spring_demo_core_lib.validation.classes;

import org.springframework.beans.BeanWrapperImpl;
import ru.geekbrains.spring_demo_core_lib.validation.intefaces.StringDateGreaterOrEqualsThan;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Валиадатор для проверки что одна дата больше или равно другой.
 */
public class StringDateGreaterOrEqualsThenValidator implements ConstraintValidator<StringDateGreaterOrEqualsThan, Object> {

    private String field;
    private String secondField;

    @Override
    public void initialize(StringDateGreaterOrEqualsThan greaterOrEqualsThan){
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
        if (!(value instanceof String) || !(secondValue instanceof String) ) {
            //throw new  NumberFormatException("Значения не являются числами");
            return false;
        }

        String sDateFrom = (String) secondValue;
        String sDateTo = (String) value;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom;
        Date dateTo;
        try {
            dateFrom = dateFormat.parse(sDateFrom);
            dateTo = dateFormat.parse(sDateTo);
        } catch (ParseException e) {
            // Не удалось спарсить данные
            return false;
        }

        return dateTo.getTime() >= dateFrom.getTime();
    }
}
