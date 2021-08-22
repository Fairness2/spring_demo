package ru.geekbrains.spring_demo_products_ms.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring_demo_products_ms.model.entity.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String title;
    private Integer cost;
    private CategoryDto category;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
        this.category = new CategoryDto(product.getCategory());
    }
}
