package ru.geekbrains.spring_demo_auth_ms.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring_demo_auth_ms.models.entity.Role;
import ru.geekbrains.spring_demo_core_lib.classes.JwtPayload;
import ru.geekbrains.spring_demo_core_lib.exceptions.LoginException;
import ru.geekbrains.spring_demo_core_lib.providers.JwtProvider;
import ru.geekbrains.spring_demo_auth_ms.models.entity.User;
import ru.geekbrains.spring_demo_auth_ms.services.UserService;
import ru.geekbrains.spring_demo_router_lib.dto.LoginRequestDto;
import ru.geekbrains.spring_demo_router_lib.dto.LoginResponseDto;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    private final UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto) {
        User user = userService.getUserByCredentials(requestDto.getUsername(), requestDto.getPassword());
        if (user == null) {
            throw new LoginException("Неверные логин или пароль");
        }
        try {
            String token = jwtProvider.createToken(
                    new JwtPayload(
                            user.getUsername(),
                            requestDto.getPassword(),
                            user.getRoles().stream().
                                    map(Role::getName).
                                    collect(Collectors.toList())
                    )
            );
            return new LoginResponseDto(token);
        }
        catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            throw new LoginException("Сгенерировать токен не удалось");
        }
    }
}
