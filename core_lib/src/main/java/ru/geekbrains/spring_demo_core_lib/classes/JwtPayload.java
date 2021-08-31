package ru.geekbrains.spring_demo_core_lib.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtPayload {
    private String username;
    private String password;
    private List<String> rights;
}
