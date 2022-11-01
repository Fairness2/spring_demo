package ru.geekbrains.spring_demo_auth_ms.models.dto;

import lombok.Data;
import ru.geekbrains.spring_demo_auth_ms.validation.interfaces.UserNotExist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * ДТОшка для регистрации пользователя
 */
@Data
public class RegistrationUserDto {

    @NotBlank(message = "Логин не должен быть пустым")
    @UserNotExist
    @Size(min = 2, max = 255, message = "Логин содержать от 2-х до 255-и символов")
    private String username;
    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 6, message = "пароль должен содержать от 6-и символов")
    private String password;
}
