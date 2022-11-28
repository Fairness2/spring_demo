package ru.geekbrains.sring_demo_order_ms.models.entites;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "order")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "user_id")
    private LocalDateTime userId;

    @ManyToMany
    @JoinTable(
            name = "ref_order_status",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "status_code"))
    private List<OrderStatus> statuses;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;

    @OneToMany(mappedBy = "order")
    private List<RefOrderStatus> orderStatuses;
}
