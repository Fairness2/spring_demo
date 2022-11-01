package ru.geekbrains.spring_demo_core_lib.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Данные, которые хранятся в jwt токене
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtPayload {
    private String username;
    private List<String> rights;
}
