package ru.geekbrains.spring_demo_front_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring_demo_router_lib.clients.ProductClient;
import ru.geekbrains.spring_demo_router_lib.dto.ProductListDto;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductClient productClient;

    @GetMapping
    public ProductListDto getProducts(@RequestParam() MultiValueMap<String, String> params) {
        return productClient.getProducts(params);
    }
}
