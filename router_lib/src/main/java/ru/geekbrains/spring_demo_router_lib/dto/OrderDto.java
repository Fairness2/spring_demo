package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderDto {
    private Integer id;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private ProductListDto products;
    private RefOrderStatusListDto statuses;

    public OrderDto(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, ProductListDto products, RefOrderStatusListDto statuses) {
        this.id = id;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        this.createdAt = createdAt != null ? dateFormat.format(createdAt) : null;
        this.updatedAt = updatedAt != null ? dateFormat.format(updatedAt) : null;
        this.deletedAt = deletedAt != null ? dateFormat.format(deletedAt) : null;
        this.products = products;
        this.statuses = statuses;
    }
}
