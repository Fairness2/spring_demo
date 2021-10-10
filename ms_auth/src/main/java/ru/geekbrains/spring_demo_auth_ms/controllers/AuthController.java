package ru.geekbrains.spring_demo_auth_ms.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_demo_auth_ms.models.entity.Role;
import ru.geekbrains.spring_demo_core_lib.services.TokenService;
import ru.geekbrains.spring_demo_core_lib.classes.JwtPayload;
import ru.geekbrains.spring_demo_core_lib.exceptions.LoginException;
import ru.geekbrains.spring_demo_core_lib.providers.JwtProvider;
import ru.geekbrains.spring_demo_auth_ms.models.entity.User;
import ru.geekbrains.spring_demo_auth_ms.services.UserService;
import ru.geekbrains.spring_demo_router_lib.dto.LoginRequestDto;
import ru.geekbrains.spring_demo_router_lib.dto.LoginResponseDto;
import ru.geekbrains.spring_demo_router_lib.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    private final UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private TokenService tokenService;

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

    @PostMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (hasText(token) && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        if (jwtProvider.validateToken(token)) {
            return tokenService.addTokenToExpired(token);
        }
        else {
            return false;
        }
    }

    @PostMapping("/registration")
    public UserDto registration(@RequestBody UserDto userDto) {
        User user = userService.createUser(userDto);
        userDto.setId(user.getId());
        return userDto;
    }
}
