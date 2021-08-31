package ru.geekbrains.spring_demo_products_ms.services;

import ru.geekbrains.spring_demo_router_lib.dto.CategoryDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo_core_lib.exceptions.ProductNotFoundException;
import ru.geekbrains.spring_demo_router_lib.dto.ProductDto;
import ru.geekbrains.spring_demo_products_ms.models.enitites.Product;
import ru.geekbrains.spring_demo_products_ms.repositories.ProductRepository;

@Service
@Data
public class ProductService {

    @Autowired
    private ProductRepository repository;

    private Integer perPage = 5;

    public Page<ProductDto> getAll(Integer page, Specification<Product> specification) {
        return repository.findAll(specification, PageRequest.of(page, perPage)).map(product -> new ProductDto(product.getId(), product.getTitle(), product.getCost(), new CategoryDto(product.getCategory().getId(), product.getCategory().getName())));
    }

    public ProductDto getOne(Integer id) {
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Продукт не найден"));
        return new ProductDto(product.getId(), product.getTitle(), product.getCost(), new CategoryDto(product.getCategory().getId(), product.getCategory().getName()));
    }

    public Integer add(ProductDto product) {
        if (product.getId() != null && repository.existsById(product.getId())) {
            throw new ProductNotFoundException("Продукт существует");
        }
        return (repository.save(new Product(product))).getId();
    }

    public Integer update(ProductDto product) {
        if (!repository.existsById(product.getId())) {
            throw new ProductNotFoundException("Продукт существует");
        }
        return (repository.save(new Product(product))).getId();
    }

    public void delete(Integer id) {
        if (id == null || !repository.existsById(id)) {
            throw new ProductNotFoundException("Продукт не существует");
        }
        repository.deleteById(id);
    }
}
