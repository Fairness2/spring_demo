package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderStatusDto {
    private String code;
    private String title;

    public OrderStatusDto(String code, String title) {
        this.code = code;
        this.title = title;
    }
}
