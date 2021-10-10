package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class UserDto {
    Integer id;
    String username;
    String password;
}
