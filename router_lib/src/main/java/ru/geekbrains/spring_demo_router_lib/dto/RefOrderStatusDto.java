package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RefOrderStatusDto {
    private Integer id;
    private Integer orderId;
    private String statusCode;
    private String createdAt;
    private String updatedAt;
    private OrderStatusDto status;

    public RefOrderStatusDto(Integer id, Integer orderId, String statusCode, LocalDateTime createdAt, LocalDateTime updatedAt, OrderStatusDto status) {
        this.id = id;
        this.orderId = orderId;
        this.statusCode = statusCode;
        this.status = status;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        this.createdAt = createdAt != null ? dateFormat.format(createdAt) : null;
        this.updatedAt = createdAt != null ? dateFormat.format(updatedAt) : null;
    }
}
