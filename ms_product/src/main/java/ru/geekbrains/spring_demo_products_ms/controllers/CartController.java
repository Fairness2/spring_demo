package ru.geekbrains.spring_demo_products_ms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_demo_core_libs.exceptions.InvalidParamsException;
import ru.geekbrains.spring_demo_products_ms.model.dto.CartDto;
import ru.geekbrains.spring_demo_products_ms.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public CartDto getCart() {
        return cartService.getCart();
    }

    @PostMapping
    public Integer addProduct(@RequestParam(required = true, name = "product_id") Integer productId,
                              @RequestParam(defaultValue = "1") Integer count) {
        if (count <= 0 ) {
            throw new InvalidParamsException("Количество не может быть меньше нуля или равно нулю");
        }

        return cartService.add(productId, count);
    }

    @DeleteMapping
    public Integer removeProduct(@RequestParam(required = true, name = "product_id") Integer productId,
                              @RequestParam(defaultValue = "1") Integer count) {
        if (count <= 0 ) {
            throw new InvalidParamsException("Количество не может быть меньше нуля или равно нулю");
        }

        return cartService.remove(productId, count);
    }
}
