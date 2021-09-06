package ru.geekbrains.spring_demo_front_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring_demo_front_ms.clients.ProductClient;
import ru.geekbrains.spring_demo_router_lib.dto.ProductDto;
import ru.geekbrains.spring_demo_router_lib.dto.ProductListDto;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductClient productClient;

    @GetMapping
    public ProductListDto getProducts() {
        return productClient.getProducts();
    }
}
