package ru.geekbrains.spring_demo_payment_ms.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "payment_status")
@NoArgsConstructor
public class PaymentStatus {
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "title")
    private String title;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "status")
    private List<Payment> payments;

    public PaymentStatus(String code, String title) {
        this.title = title;
        this.code = code;
    }

}
