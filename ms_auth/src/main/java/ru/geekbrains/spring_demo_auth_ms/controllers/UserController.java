package ru.geekbrains.spring_demo_auth_ms.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_demo_auth_ms.models.entity.User;
import ru.geekbrains.spring_demo_auth_ms.services.UserService;
import ru.geekbrains.spring_demo_core_lib.models.CustomUserDetails;
import ru.geekbrains.spring_demo_router_lib.dto.UserDto;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    /**
     * Получение пользователя по id
     * @param id
     * @return UserDto
     */
    @PostMapping("/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    /**
     * Получение авторизованного пользователя
     * @return UserDto
     */
    @PostMapping("/me")
    public UserDto getUserByToken() {
        CustomUserDetails details = (CustomUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        String username = details.getUsername();
        User user = userService.getUserByUsername(username);
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
