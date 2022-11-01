package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDto {

    @NotBlank(message = "Логин не должен быть пустым")
    private String username;
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
}
