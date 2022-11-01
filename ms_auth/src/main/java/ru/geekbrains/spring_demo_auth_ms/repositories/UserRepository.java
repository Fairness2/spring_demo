package ru.geekbrains.spring_demo_auth_ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_demo_auth_ms.models.entity.User;

import java.util.Optional;

/**
 * Репозиторий пользователей
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Поиск по юзернейму
     * @param username
     * @return
     */
    Optional<User> findByUsername(String username);
}
