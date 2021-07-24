package ru.geekbrains.spring_demo.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import ru.geekbrains.spring_demo.exceptions.ProductNotFoundException;
import ru.geekbrains.spring_demo.model.dto.ProductDto;
import ru.geekbrains.spring_demo.model.entity.HiProduct;
import ru.geekbrains.spring_demo.repositories.ProductRepository;

import java.util.Optional;

@Service
@Data
public class ProductService {

    @Autowired
    private ProductRepository repository;

    private Integer perPage = 5;

    public Page<ProductDto> getAll(Integer page, Specification<HiProduct> specification) {
        /*if (max == null && like == null) {
            return repository.findAllByCostGreaterThanEqual(min, PageRequest.of(page, perPage)).map(ProductDto::new);
        }
        else if (like == null){
            return repository.findAllByCostBetween(min, max, PageRequest.of(page, perPage)).map(ProductDto::new);
        }
        else if (max == null) {
            return repository.findAllByCostGreaterThanEqualAndTitleLike(min, '%' + like + '%', PageRequest.of(page, perPage)).map(ProductDto::new);
        }
        else {
            return repository.findAllByCostBetweenAndTitleLike(min, max,'%' + like + '%', PageRequest.of(page, perPage)).map(ProductDto::new);
            //return repository.findAll();
        }*/

        return repository.findAll(specification, PageRequest.of(page, perPage)).map(ProductDto::new);
    }

    public ProductDto getOne(Integer id) {
        Optional<HiProduct> optional = repository.findById(id);
        return new ProductDto(optional.orElseThrow(() -> new ProductNotFoundException("Продукт не найден")));
    }

    public Integer add(ProductDto product) {
        if (product.getId() != null && repository.existsById(product.getId())) {
            throw new ProductNotFoundException("Продукт существует");
        }
        return (repository.save(new HiProduct(product))).getId();
    }

    public Integer update(ProductDto product) {
        if (!repository.existsById(product.getId())) {
            throw new ProductNotFoundException("Продукт существует");
        }
        return (repository.save(new HiProduct(product))).getId();
    }

    public void delete(Integer id) {
        if (id == null || !repository.existsById(id)) {
            throw new ProductNotFoundException("Продукт не существует");
        }
        repository.deleteById(id);
    }
}
