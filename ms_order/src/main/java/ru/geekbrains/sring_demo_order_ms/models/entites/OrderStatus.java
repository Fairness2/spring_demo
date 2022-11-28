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
@Table(name = "order_status")
@NoArgsConstructor
public class OrderStatus {
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "ref_order_status",
            joinColumns = @JoinColumn(name = "status_code"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;

    public OrderStatus( String code, String title) {
        this.title = title;
        this.code = code;
    }

}
