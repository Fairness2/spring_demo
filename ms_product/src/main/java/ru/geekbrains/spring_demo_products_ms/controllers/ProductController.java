package ru.geekbrains.spring_demo_products_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_demo_router_lib.dto.ProductDto;
import ru.geekbrains.spring_demo_products_ms.repositories.specifications.ProductSpecifications;
import ru.geekbrains.spring_demo_products_ms.services.ProductService;
import ru.geekbrains.spring_demo_router_lib.dto.ProductListDto;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ProductListDto getProducts(@RequestParam() MultiValueMap<String, String> params) {
        if (params.containsKey("page") && !params.getFirst("page").isBlank()) {
            int page = 1;
            try {
                page = Integer.parseInt(params.getFirst("page"));
            }
            catch (NumberFormatException ignored) { }
            page = Math.max(page, 1);
            Page<ProductDto> productPage = productService.getAll(page - 1, ProductSpecifications.build(params));
            return new ProductListDto(productPage.getContent(), productPage.getNumber(), productPage.getTotalPages());
        }
        else {
            List<ProductDto> productList = productService.getAll(ProductSpecifications.build(params));
            return new ProductListDto(productList, productList.size(), 1);
        }
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
