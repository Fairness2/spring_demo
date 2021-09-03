package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductListDto {
    private List<ProductDto> products;
    private int page;
    private int total;

    public ProductListDto(List<ProductDto> products, int page, int total) {
        this.products = products;
        this.page = page;
        this.total = total;
    }
}
