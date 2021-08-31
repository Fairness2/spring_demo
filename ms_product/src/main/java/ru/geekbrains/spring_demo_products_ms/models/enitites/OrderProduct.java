package ru.geekbrains.spring_demo_products_ms.models.enitites;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderProduct {
    private Integer id;
    private Integer cost;
    private Integer orderId;
}
