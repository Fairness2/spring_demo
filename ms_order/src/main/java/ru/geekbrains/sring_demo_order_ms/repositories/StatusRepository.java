package ru.geekbrains.sring_demo_order_ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.sring_demo_order_ms.models.entites.OrderStatus;

@Repository
public interface StatusRepository extends JpaRepository<OrderStatus, String> {

}
