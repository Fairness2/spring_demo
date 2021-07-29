package ru.geekbrains.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo.exceptions.UserNotFoundException;
import ru.geekbrains.spring_demo.model.entity.User;
import ru.geekbrains.spring_demo.repositories.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Неверные имя пользователя или пароль"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), this.getUserAuthority(user));
    }

    private Collection<? extends GrantedAuthority> getUserAuthority(User user) {
        return user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
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
