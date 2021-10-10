package ru.geekbrains.spring_demo_auth_ms.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_demo_auth_ms.models.entity.Role;
import ru.geekbrains.spring_demo_auth_ms.models.entity.User;
import ru.geekbrains.spring_demo_auth_ms.services.UserService;
import ru.geekbrains.spring_demo_core_lib.classes.JwtPayload;
import ru.geekbrains.spring_demo_core_lib.exceptions.LoginException;
import ru.geekbrains.spring_demo_core_lib.providers.JwtProvider;
import ru.geekbrains.spring_demo_core_lib.services.TokenService;
import ru.geekbrains.spring_demo_router_lib.dto.LoginRequestDto;
import ru.geekbrains.spring_demo_router_lib.dto.LoginResponseDto;
import ru.geekbrains.spring_demo_router_lib.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
