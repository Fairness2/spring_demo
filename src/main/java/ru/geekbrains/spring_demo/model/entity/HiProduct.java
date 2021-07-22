package ru.geekbrains.spring_demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.geekbrains.spring_demo.model.dto.ProductDto;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public HiProduct(String title, Integer cost) {
        this.title = title;
        this.cost = cost;
    }

    public HiProduct(ProductDto dto) {
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.cost = dto.getCost();
        this.category = new Category(dto.getCategory());
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
