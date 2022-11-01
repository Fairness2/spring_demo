package ru.geekbrains.spring_demo_core_lib.models.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

/**
 * Хранение истёкших токенов
 */
@RedisHash(value = "loginToken", timeToLive = 3600) //TODO перевести на конфиг
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpiredToken implements Serializable {
    private String id;
    @Indexed
    private String token;
}
