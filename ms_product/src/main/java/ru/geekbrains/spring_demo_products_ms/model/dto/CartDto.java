package ru.geekbrains.spring_demo_products_ms.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring_demo_products_ms.model.entity.Cart;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class CartDto {
    private final ArrayList<ChartItemDto> items = new ArrayList<>();
    private Integer cost;

    public CartDto(Cart cart) {
        cart.getProducts().forEach((key, val) -> {
            items.add(new ChartItemDto(key, val));
        });
        cost = cart.getCost();
    }
}
