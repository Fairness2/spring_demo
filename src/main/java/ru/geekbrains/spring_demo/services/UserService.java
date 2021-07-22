package ru.geekbrains.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo.model.entity.User;
import ru.geekbrains.spring_demo.model.entity.UserProduct;
import ru.geekbrains.spring_demo.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    /*@Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.getAll();
    }

    public User getOne(Integer id) {
        return repository.getOne(id);
    }

    public User add(String name) {
        return repository.create(name);
    }

    public User update(Integer id, String name) {
        return repository.update(id, name);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public List<UserProduct> userProducts(User user) {
        return repository.getUserProducts(user);
    }*/
}
