package ru.geekbrains.spring_demo_products_ms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring_demo_products_ms.config.JwtProvider;
import ru.geekbrains.spring_demo_core_libs.exceptions.UserNotFoundException;
import ru.geekbrains.spring_demo_products_ms.model.dto.LoginRequestDto;
import ru.geekbrains.spring_demo_products_ms.model.dto.LoginResponseDto;
import ru.geekbrains.spring_demo_products_ms.model.entity.User;
import ru.geekbrains.spring_demo_products_ms.services.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto) {
        User user = userService.getUserByCredentials(requestDto.getUsername(), requestDto.getPassword());
        if (user == null) {
            throw new UserNotFoundException("Неверные логин или пароль");
        }
        return new LoginResponseDto(jwtProvider.createToken(user.getUsername()));
    }
}
