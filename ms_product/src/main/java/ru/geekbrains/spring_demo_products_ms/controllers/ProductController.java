package ru.geekbrains.spring_demo_products_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_demo_products_ms.exceptions.ProductNotFoundException;
import ru.geekbrains.spring_demo_products_ms.models.dto.ProductCreateDto;
import ru.geekbrains.spring_demo_products_ms.models.dto.ProductRequestDto;
import ru.geekbrains.spring_demo_products_ms.models.dto.ProductUpdateDto;
import ru.geekbrains.spring_demo_products_ms.models.enitites.Product;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.ProductExist;
import ru.geekbrains.spring_demo_router_lib.dto.CategoryDto;
import ru.geekbrains.spring_demo_router_lib.dto.ProductDto;
import ru.geekbrains.spring_demo_products_ms.repositories.specifications.ProductSpecifications;
import ru.geekbrains.spring_demo_products_ms.services.ProductService;
import ru.geekbrains.spring_demo_router_lib.dto.ProductListDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Рест контроллер для взаимодействия с продуктами.
 */
@Validated
@RestController
@RequestMapping("/products")
public class ProductController {
    /**
     * Сервис наших продуктов
     */
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Получение списка продуктов
     */
    @GetMapping
    public ProductListDto getProducts(@RequestBody @Valid ProductRequestDto requestDto) {
        Specification<Product> specification = ProductSpecifications.build(requestDto);
        int page = requestDto.getPage() == null ? 1 : requestDto.getPage();
        Page<Product> productPage = productService.getAll(page, specification);
        List<ProductDto> products = productPage.getContent()
                .stream()
                .map(product -> new ProductDto(
                        product.getId(),
                        product.getTitle(),
                        product.getCost(),
                        new CategoryDto(
                                product.getCategory().getId(),
                                product.getCategory().getName()
                        )
                ))
                .collect(Collectors.toList());

        return new ProductListDto(products, page, productPage.getTotalPages());
    }

    /**
     * Получение определённого продукта
     */
    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable("id") @Positive @NotNull Integer id) {
        Product product = productService.getOne(id);
        if (product == null) {
            throw new ProductNotFoundException("Продукт не найден");
        }

        return new ProductDto(product.getId(), product.getTitle(), product.getCost(), new CategoryDto(product.getCategory().getId(), product.getCategory().getName()));
    }

    /**
     * Добавление нового продукта
     */
    @PostMapping
    public Integer addProduct(@Valid @RequestBody ProductCreateDto productDto) {
        Product product = new Product(productDto);
        product = productService.add(product);

        return product.getId();
    }

    /**
     * Обновление существующего продукта
     */
    @PutMapping
    public Integer updateProduct(@Valid @RequestBody ProductUpdateDto productDto) {
        Product product = new Product(productDto);
        product = productService.update(product);

        return product.getId();
    }

    /**
     * Удаление существующего продукта
     */
    @DeleteMapping
    public boolean deleteProduct(@RequestParam @ProductExist @Positive @NotNull Integer id) {
        return productService.delete(id);
    }
}
