package ru.geekbrains.spring_demo_products_ms.model.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String username;
    private String password;
}
