package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderStatusListDto {
    private List<OrderStatusDto> statuses;

    public OrderStatusListDto(List<OrderStatusDto> statuses) {
        this.statuses = statuses;
    }
}
