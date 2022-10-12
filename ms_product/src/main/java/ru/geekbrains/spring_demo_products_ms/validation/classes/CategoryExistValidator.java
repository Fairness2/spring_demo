package ru.geekbrains.spring_demo_products_ms.validation.classes;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.spring_demo_products_ms.repositories.CategoryRepository;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.CategoryExist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Валиадатор для проверки наличия такой категории.
 */
public class CategoryExistValidator implements ConstraintValidator<CategoryExist, Integer> {

    @Autowired
    private CategoryRepository repository;

    @Override
    public void initialize(CategoryExist categoryExist){}

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer == null || repository.existsById(integer);
    }
}
