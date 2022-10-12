package ru.geekbrains.spring_demo_products_ms.validation.classes;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.spring_demo_products_ms.repositories.ProductRepository;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.ProductListExist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Валиадатор для проверки наличия всего списка продуктов.
 */
public class ProductListExistValidator implements ConstraintValidator<ProductListExist, List<Integer>> {

    @Autowired
    private ProductRepository repository;

    @Override
    public void initialize(ProductListExist productListExist){}

    @Override
    public boolean isValid(List<Integer> ids, ConstraintValidatorContext constraintValidatorContext) {
        if (ids == null) {
            return true;
        }
        int countProducts = repository.countAllByIdIn(ids);

        return countProducts == ids.size();
    }
}
