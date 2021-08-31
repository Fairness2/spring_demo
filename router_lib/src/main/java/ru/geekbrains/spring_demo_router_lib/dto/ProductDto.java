package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String title;
    private Integer cost;
    private CategoryDto category;

    public ProductDto(Integer id, String title, Integer cost, CategoryDto category) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.category = category;
    }
}
