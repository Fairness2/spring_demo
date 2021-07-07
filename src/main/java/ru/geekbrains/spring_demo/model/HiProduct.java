package ru.geekbrains.spring_demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class HiProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private int cost;


    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof HiProduct) {
            return this.id.equals(((HiProduct) anObject).id);
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("Product: {%nID: %s%nTitle: %s%nCost: %s%n}%n", id, title, cost);
    }

}
