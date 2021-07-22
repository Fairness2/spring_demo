package ru.geekbrains.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo.model.entity.HiProduct;
import ru.geekbrains.spring_demo.model.entity.User;
import ru.geekbrains.spring_demo.model.entity.UserProduct;
import ru.geekbrains.spring_demo.repositories.UserProductRepository;

import java.util.List;

@Service
public class UserProductService {

    /*@Autowired
    private UserProductRepository repository;

    public List<UserProduct> getAll() {
        return repository.getAll();
    }

    public UserProduct getOne(Integer id) {
        return repository.getOne(id);
    }

    public UserProduct add(User user, HiProduct product, Integer currentCost) {
        return repository.create(user, product, currentCost);
    }

    public UserProduct update(Integer id, User user, HiProduct product, Integer currentCost) {
        return repository.update(id, user, product, currentCost);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }*/
}
