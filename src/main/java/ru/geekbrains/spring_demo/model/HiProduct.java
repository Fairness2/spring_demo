package ru.geekbrains.spring_demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
public class HiProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private Integer cost;

    public HiProduct(String title, Integer cost) {
        this.title = title;
        this.cost = cost;
    }

    /*@OneToMany(mappedBy = "product")
    private List<UserProduct> userProducts;

    @ManyToMany
    @JoinTable (
            name = "ref_user_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;


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
    }*/

}
