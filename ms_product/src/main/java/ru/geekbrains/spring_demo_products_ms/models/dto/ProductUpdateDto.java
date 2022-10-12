package ru.geekbrains.spring_demo_products_ms.models.dto;

import lombok.NoArgsConstructor;
import ru.geekbrains.spring_demo_products_ms.models.enitites.Product;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.ProductExist;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
public class ProductUpdateDto extends ProductCreateDto {
    @Positive(message = "ID должно быть числом больше 0-я")
    @NotNull(message = "ID продукта обязательно")
    @ProductExist
    protected Integer id;

    public ProductUpdateDto(Product product) {
        super(product);
        this.id = product.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
