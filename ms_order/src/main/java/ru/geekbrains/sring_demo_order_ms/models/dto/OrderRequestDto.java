package ru.geekbrains.sring_demo_order_ms.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring_demo_core_lib.validation.intefaces.DateFormat;
import ru.geekbrains.spring_demo_core_lib.validation.intefaces.StringDateGreaterOrEqualsThan;
import ru.geekbrains.sring_demo_order_ms.validation.interfaces.StatusExist;

import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@StringDateGreaterOrEqualsThan.List({
        @StringDateGreaterOrEqualsThan(
                field = "dateTo",
                secondField = "dateFrom",
                message = "Дата \"до\" не может быть меньше даты \"от\""
        )
})
public class OrderRequestDto {
    @Positive
    private Integer page;
    @DateFormat
    private String dateFrom;
    @DateFormat
    private String dateTo;
    @StatusExist
    private String status;
}
