package ru.geekbrains.spring_demo.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ref_user_product")
public class UserProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "current_cost")
    private Integer currentCost;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private HiProduct product;

}
