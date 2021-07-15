package ru.geekbrains.spring_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.geekbrains.spring_demo.model.HiProduct;
import ru.geekbrains.spring_demo.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<HiProduct> showHomePage(@RequestParam(defaultValue = "0") Integer min, @RequestParam(required = false) Integer max, @RequestParam(required = false) String like, @RequestParam(defaultValue = "1") Integer page) {
        return productService.getAll(page - 1, min, max, like);
    }

    @GetMapping("/{id}")
    public HiProduct showHomePage(@PathVariable Integer id) {
        return productService.getOne(id);
    }

    @PostMapping
    public HiProduct addProduct(@RequestBody HiProduct product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        return product;
    }

    @PutMapping
    public HiProduct updateProduct(@RequestBody HiProduct product) {
        productService.update(product);
        return product;
    }

    @DeleteMapping
    public Integer addProduct(@RequestParam Integer id) {
        productService.delete(id);
        return id;
    }
}
