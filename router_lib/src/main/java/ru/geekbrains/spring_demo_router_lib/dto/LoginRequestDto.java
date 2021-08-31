package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String username;
    private String password;
}
