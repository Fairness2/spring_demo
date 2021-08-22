package ru.geekbrains.spring_demo_products_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_demo_products_ms.model.dto.ProductDto;
import ru.geekbrains.spring_demo_products_ms.repositories.specifications.ProductSpecifications;
import ru.geekbrains.spring_demo_products_ms.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductDto> getProducts(@RequestParam() MultiValueMap<String, String> params, @RequestParam(defaultValue = "1") Integer page) {
        page = page < 1 ? 1 : page;
        return productService.getAll(page - 1, ProductSpecifications.build(params));
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Integer id) {
        return productService.getOne(id);
    }

    @PostMapping
    public Integer addProduct(@RequestBody ProductDto product) {
        return productService.add(product);
    }

    @PutMapping
    public Integer updateProduct(@RequestBody ProductDto product) {
        return productService.update(product);
    }

    @DeleteMapping
    public Integer addProduct(@RequestParam Integer id) {
        productService.delete(id);
        return id;
    }
}
