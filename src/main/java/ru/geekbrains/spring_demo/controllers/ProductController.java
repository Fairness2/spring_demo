package ru.geekbrains.spring_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.geekbrains.spring_demo.model.dto.ProductDto;
import ru.geekbrains.spring_demo.model.entity.HiProduct;
import ru.geekbrains.spring_demo.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductDto> getProducts(@RequestParam(defaultValue = "0") Integer min, @RequestParam(required = false) Integer max, @RequestParam(required = false) String like, @RequestParam(defaultValue = "1") Integer page) {
        page = page < 1 ? 1 : page;
        return productService.getAll(page - 1, min, max, like);
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
