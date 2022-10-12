package ru.geekbrains.spring_demo_products_ms.validation.classes;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.spring_demo_products_ms.repositories.ProductRepository;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.ProductExist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Валиадатор для проверки наличия продукта.
 */
public class ProductExistValidator implements ConstraintValidator<ProductExist, Integer> {

    @Autowired
    private ProductRepository repository;

    @Override
    public void initialize(ProductExist productExist){}

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer == null || repository.existsById(integer);
    }
}
