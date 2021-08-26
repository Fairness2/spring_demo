package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class CartDto {
    private final ArrayList<ChartItemDto> items = new ArrayList<>();
    private Integer cost;
}
