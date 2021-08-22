package ru.geekbrains.spring_demo_products_ms.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring_demo_products_ms.model.entity.Category;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Integer id;
    private String name;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
