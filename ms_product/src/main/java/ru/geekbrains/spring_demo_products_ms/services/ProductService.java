package ru.geekbrains.spring_demo_products_ms.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo_core_libs.exceptions.ProductNotFoundException;
import ru.geekbrains.spring_demo_products_ms.model.dto.ProductDto;
import ru.geekbrains.spring_demo_products_ms.model.entity.Product;
import ru.geekbrains.spring_demo_products_ms.repositories.ProductRepository;

import java.util.Optional;

@Service
@Data
public class ProductService {

    @Autowired
    private ProductRepository repository;

    private Integer perPage = 5;

    public Page<ProductDto> getAll(Integer page, Specification<Product> specification) {
        return repository.findAll(specification, PageRequest.of(page, perPage)).map(ProductDto::new);
    }

    public ProductDto getOne(Integer id) {
        Optional<Product> optional = repository.findById(id);
        return new ProductDto(optional.orElseThrow(() -> new ProductNotFoundException("Продукт не найден")));
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
