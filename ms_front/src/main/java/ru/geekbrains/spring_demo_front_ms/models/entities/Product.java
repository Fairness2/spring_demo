package ru.geekbrains.spring_demo_front_ms.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring_demo_router_lib.dto.ProductDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String title;
    private Integer cost;
    private String category;

    public Product(ProductDto dto) {
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.cost = dto.getCost();
        this.category = dto.getCategory().getName();
    }

}
