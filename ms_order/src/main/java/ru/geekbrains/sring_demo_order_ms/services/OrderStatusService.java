package ru.geekbrains.sring_demo_order_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.sring_demo_order_ms.models.entites.OrderStatus;
import ru.geekbrains.sring_demo_order_ms.repositories.StatusRepository;

import java.util.List;

@Service
public class OrderStatusService {
    private StatusRepository repository;

    @Autowired
    private void setRepository(StatusRepository repository) {
        this.repository = repository;
    }


    public List<OrderStatus> getOrderStatuses() {
        return repository.findAll();
    }
}
