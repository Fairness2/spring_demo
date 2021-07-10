package ru.geekbrains.spring_demo.services;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo.exceptions.ProductNotFoundException;
import ru.geekbrains.spring_demo.model.HiProduct;
import ru.geekbrains.spring_demo.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<HiProduct> getAll(Integer min, Integer max, String like) {
        if (max == null && like == null) {
            return repository.findAllByCostGreaterThanEqual(min);
        }
        else if (like == null){
            return repository.findAllByCostBetween(min, max);
        }
        else if (max == null) {
            return repository.findAllByCostGreaterThanEqualAndTitleLike(min, '%' + like + '%');
        }
        else {
            return repository.findAllByCostBetweenAndTitleLike(min, max,'%' + like + '%');
            //return repository.findAll();
        }
    }

    public HiProduct getOne(Integer id) {
        Optional<HiProduct> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ProductNotFoundException("Продукт не найден"));
    }

    public HiProduct add(HiProduct product) {
        if (product.getId() != null && repository.existsById(product.getId())) {
            throw new ProductNotFoundException("Продукт существует");
        }
        return repository.save(product);
    }

    public HiProduct update(HiProduct product) {
        if (!repository.existsById(product.getId())) {
            throw new ProductNotFoundException("Продукт существует");
        }
        return repository.save(product);
    }

    public void delete(Integer id) {
        if (id == null || !repository.existsById(id)) {
            throw new ProductNotFoundException("Продукт не существует");
        }
        repository.deleteById(id);
    }
}
