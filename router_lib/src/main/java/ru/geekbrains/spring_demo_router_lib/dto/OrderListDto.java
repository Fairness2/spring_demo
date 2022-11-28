package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderListDto {
    private List<OrderDto> orders;
    private int page;
    private int total;

    public OrderListDto(List<OrderDto> orders, int page, int total) {
        this.orders = orders;
        this.page = page;
        this.total = total;
    }
}
