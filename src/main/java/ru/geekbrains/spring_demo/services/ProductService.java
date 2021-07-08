package ru.geekbrains.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo.model.HiProduct;
import ru.geekbrains.spring_demo.model.User;
import ru.geekbrains.spring_demo.model.UserProduct;
import ru.geekbrains.spring_demo.repositories.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<HiProduct> getAll() {
        return repository.getAll();
    }

    public HiProduct getOne(Integer id) {
        return repository.getOne(id);
    }

    public HiProduct add(String title, int cost) {
        return repository.create(title, cost);
    }

    public HiProduct update(Integer id, String title, int cost) {
        return repository.update(id, title, cost);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public List<UserProduct> userProducts(HiProduct product) {
        return repository.getUserProducts(product);
    }
}
