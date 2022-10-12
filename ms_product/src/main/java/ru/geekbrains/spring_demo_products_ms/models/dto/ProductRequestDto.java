package ru.geekbrains.spring_demo_products_ms.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring_demo_core_lib.validation.intefaces.GreaterOrEqualsThan;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.CategoryExist;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.CategoryListExist;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.ProductExist;
import ru.geekbrains.spring_demo_products_ms.validation.interfaces.ProductListExist;
import ru.geekbrains.spring_demo_router_lib.dto.CategoryDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@NoArgsConstructor
@GreaterOrEqualsThan.List({
        @GreaterOrEqualsThan(
                field = "maxCost",
                secondField = "minCost",
                message = "Максимальная цена не может быть меньше минимальной"
        )
})
public class ProductRequestDto {
    @Positive
    private Integer page;
    @Positive
    private Integer minCost;
    @Positive
    private Integer maxCost;

    private String title;

    @ProductListExist
    private List<Integer> ids;

    @CategoryListExist
    private List<Integer> categories;
}
