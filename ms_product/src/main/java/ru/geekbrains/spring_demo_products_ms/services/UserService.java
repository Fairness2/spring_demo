package ru.geekbrains.spring_demo_products_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo_core_libs.exceptions.UserNotFoundException;
import ru.geekbrains.spring_demo_products_ms.model.CustomUserDetails;
import ru.geekbrains.spring_demo_products_ms.model.entity.User;
import ru.geekbrains.spring_demo_products_ms.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Неверные имя пользователя или пароль"));
        return new CustomUserDetails(user);
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    }

    public User getUserByCredentials(String username, String password) {
        User user = repository.findByUsername(username).orElse(null);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    }

    public Integer increaseUserScore(String username, int score) {
        User user = this.getUserByUsername(username);
        user.setScore(user.getScore() + score);
        repository.flush();
        return user.getScore();
    }

    public Integer decreaseUserScore(String username, int score) {
        return increaseUserScore(username, - score);
    }

    public Integer getUserScore(String username) {
        return this.getUserByUsername(username).getScore();
    }

    public Integer getUserScore(Integer id) {
        return this.getUserById(id).getScore();
    }
}
