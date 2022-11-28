package ru.geekbrains.sring_demo_order_ms.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring_demo_router_lib.dto.OrderListDto;
import ru.geekbrains.spring_demo_router_lib.dto.OrderStatusDto;
import ru.geekbrains.spring_demo_router_lib.dto.OrderStatusListDto;
import ru.geekbrains.sring_demo_order_ms.models.entites.OrderStatus;
import ru.geekbrains.sring_demo_order_ms.services.OrderStatusService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер Статусов заказов
 */
@RestController
@RequestMapping("/status")
@Slf4j
public class OrderStatusController {
    private OrderStatusService statusService;

    @Autowired
    private void setOrderService(OrderStatusService service) {
        this.statusService = service;
    }

    @GetMapping()
    public OrderStatusListDto getOrderStatuses() {
        List<OrderStatus> list = statusService.getOrderStatuses();
        List<OrderStatusDto> dtoList = list.stream()
                .map(status -> new OrderStatusDto(status.getCode(), status.getTitle()))
                .collect(Collectors.toList());

        return new OrderStatusListDto(dtoList);
    }
}
