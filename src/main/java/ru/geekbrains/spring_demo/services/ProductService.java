package ru.geekbrains.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo.model.Product;
import ru.geekbrains.spring_demo.repositories.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAll() {
        return repository.getAll();
    }

    public Product getOne(UUID uuid) {
        return repository.getOne(uuid);
    }

    public Product add(String title, int cost) {
        return repository.create(title, cost);
    }

    public Product update(String uuid, String title, int cost) {
        return repository.update(uuid, title, cost);
    }

    public boolean update(String uuid) {
        return repository.delete(uuid);
    }
}
