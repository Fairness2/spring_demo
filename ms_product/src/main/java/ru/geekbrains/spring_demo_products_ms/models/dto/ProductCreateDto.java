package ru.geekbrains.spring_demo_products_ms.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring_demo_products_ms.models.enitites.Product;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.CategoryExist;
import ru.geekbrains.spring_demo_router_lib.dto.CategoryDto;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class ProductCreateDto {
    @Size(min = 2, max = 255, message = "Название должно содержать от 2-х до 255-и символов")
    @NotBlank(message = "Название не может быть пустым")
    protected String title;
    @Positive(message = "Цена должна быть числом больше 0-я")
    @NotNull(message = "Цена не может быть пустой")
    protected Integer cost;
    @Positive(message = "Идентификатор категории должен быть числом больше 0")
    @NotNull(message = "Категория не может быть пустой")
    @CategoryExist
    protected Integer categoryId;

    public ProductCreateDto(Product product) {
        this.title = product.getTitle();
        this.cost = product.getCost();
        this.categoryId = product.getCategory().getId();
    }
}
