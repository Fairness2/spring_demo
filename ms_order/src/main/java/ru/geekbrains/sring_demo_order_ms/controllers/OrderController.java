package ru.geekbrains.sring_demo_order_ms.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring_demo_router_lib.dto.OrderListDto;
import ru.geekbrains.sring_demo_order_ms.services.OrderService;

/**
 * Контроллер заказов
 */
@RestController
@RequestMapping("/")
@Slf4j
public class OrderController {
    private OrderService orderService;

    @Autowired
    private void setOrderService(OrderService service) {
        this.orderService = service;
    }

    /*@GetMapping()
    public OrderListDto getUserOrders() {

    }*/
}
