package ru.geekbrains.spring_demo_core_lib.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo_core_lib.models.redis.ExpiredToken;
import ru.geekbrains.spring_demo_core_lib.repositories.ExpiredTokenRepository;

/**
 * Сервис токенов
 */
@Service
public class TokenService {
    @Autowired
    private ExpiredTokenRepository tokenRepository;

    /**
     * Запишем токен как протухший
     * @param token
     * @return boolean
     */
    public boolean addTokenToExpired(String token) {
        ExpiredToken expiredToken = new ExpiredToken();
        expiredToken.setToken(token);
        tokenRepository.save(expiredToken);
        return true;
    }

    /**
     * Проверим есть ли токен среди истёкших
     * @param token
     * @return boolean
     */
    public boolean tokenExist(String token) {
        return tokenRepository.findByToken(token) != null;
    }
}
