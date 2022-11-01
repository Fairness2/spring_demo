package ru.geekbrains.spring_demo_auth_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo_core_lib.exceptions.UserNotFoundException;
import ru.geekbrains.spring_demo_auth_ms.models.entity.User;
import ru.geekbrains.spring_demo_auth_ms.repositories.UserRepository;

/**
 * Сервис пользовователей
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Поиск пользователей по юзернейму
     * @param username
     * @return User
     */
    public User getUserByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    }

    /**
     * Получим пользователя по
     * @param username
     * @param password
     * @return User
     */
    public User getUserByCredentials(String username, String password) {
        User user = repository.findByUsername(username).orElse(null);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    /**
     * Получение пользователя по ID
     * @param id
     * @return User
     */
    public User getUserById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    }

    /**
     * Сохранение пользователя
     * @param user
     * @return User
     */
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
