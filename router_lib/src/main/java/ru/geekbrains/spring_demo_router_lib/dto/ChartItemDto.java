package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChartItemDto {
    private ProductDto product;
    private Integer count;

    public ChartItemDto(ProductDto product, Integer count) {
        this.product = product;
        this.count = count;
    }
}
