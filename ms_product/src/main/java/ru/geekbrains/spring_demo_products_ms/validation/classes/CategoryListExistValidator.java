package ru.geekbrains.spring_demo_products_ms.validation.classes;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.spring_demo_products_ms.repositories.CategoryRepository;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.CategoryListExist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Валиадатор для проверки наличия всего списка категорий.
 */
public class CategoryListExistValidator implements ConstraintValidator<CategoryListExist, List<Integer>> {

    @Autowired
    private CategoryRepository repository;

    @Override
    public void initialize(CategoryListExist categoryListExist){}

    @Override
    public boolean isValid(List<Integer> ids, ConstraintValidatorContext constraintValidatorContext) {
        if (ids == null) {
            return true;
        }
        int countCategories = repository.countAllByIdIn(ids);

        return countCategories == ids.size();
    }
}
