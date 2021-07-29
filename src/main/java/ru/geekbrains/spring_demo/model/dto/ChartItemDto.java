package ru.geekbrains.spring_demo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring_demo.model.entity.Product;

@Data
@NoArgsConstructor
public class ChartItemDto {
    private ProductDto product;
    private Integer count;

    public ChartItemDto(Product product, Integer count) {
        this.product = new ProductDto(product);
        this.count = count;
    }
}
