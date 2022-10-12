package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class ProductDto {
    @Positive(message = "ID должно быть числом больше 0-я")
    private Integer id;
    @Size(min = 2, max = 255, message = "Название должно содержать от 2-х до 255-и символов")
    @NotBlank(message = "Название не может быть пустым")
    private String title;
    @Positive(message = "Цена должна быть числом больше 0-я")
    @NotNull(message = "Цена не может быть пустой")
    private Integer cost;
    @Positive(message = "Идентификатор категории должен быть числом больше 0")
    @NotBlank
    private CategoryDto category;

    public ProductDto(Integer id, String title, Integer cost, CategoryDto category) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.category = category;
    }
}
