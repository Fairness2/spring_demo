package ru.geekbrains.spring_demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable (
            name = "ref_user_product",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof UserProduct) {
            return this.id.equals(((UserProduct) anObject).id);
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("User: {%nID: %s%nName: %s%n}%n", id, name);
    }

}
