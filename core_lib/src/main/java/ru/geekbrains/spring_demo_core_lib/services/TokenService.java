package ru.geekbrains.spring_demo_core_lib.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo_core_lib.models.redis.ExpiredToken;
import ru.geekbrains.spring_demo_core_lib.repositories.ExpiredTokenRepository;

@Service
public class TokenService {
    @Autowired
    private ExpiredTokenRepository tokenRepository;

    public boolean addTokenToExpired(String token) {
        ExpiredToken expiredToken = new ExpiredToken();
        expiredToken.setToken(token);
        tokenRepository.save(expiredToken);
        return true;
    }

    public boolean tokenExist(String token) {
        return tokenRepository.findByToken(token) != null;
    }
}
