package ru.geekbrains.spring_demo_products_ms.services;

import ru.geekbrains.spring_demo_products_ms.models.dto.ProductCreateDto;
import ru.geekbrains.spring_demo_products_ms.models.dto.ProductUpdateDto;
import ru.geekbrains.spring_demo_router_lib.dto.CategoryDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo_products_ms.exceptions.ProductNotFoundException;
import ru.geekbrains.spring_demo_router_lib.dto.ProductDto;
import ru.geekbrains.spring_demo_products_ms.models.enitites.Product;
import ru.geekbrains.spring_demo_products_ms.repositories.ProductRepository;

import java.util.Optional;

@Service
@Data
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /**
     * Дефолтное кол-во на странице
     */
    private Integer perPage = 5;

    /**
     * Получим продукты по странице и параметрам фильтрации
     */
    public Page<Product> getAll(int page, Specification<Product> specification) {
        return repository.findAll(specification, PageRequest.of(page - 1, perPage));
    }

    /**
     * Получим один продукт
     */
    public Product getOne(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Добавление нового продукта
     */
    public Product add(Product product) {
        return (repository.save(product));
    }

    /**
     * Изменение продукта
     */
    public Product update(Product product) {
        return (repository.save(product));
    }

    /**
     * Удаление продукта
     */
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
