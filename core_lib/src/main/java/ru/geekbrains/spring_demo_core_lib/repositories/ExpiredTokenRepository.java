package ru.geekbrains.spring_demo_core_lib.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_demo_core_lib.models.redis.ExpiredToken;

@Repository
public interface ExpiredTokenRepository extends CrudRepository<ExpiredToken, String> {
    ExpiredToken findByToken(String token);
}
