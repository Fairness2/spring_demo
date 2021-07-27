package ru.geekbrains.spring_demo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring_demo.model.entity.Chart;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class ChartDto {
    private final ArrayList<ChartItemDto> items = new ArrayList<>();
    private Integer cost;

    public ChartDto(Chart chart) {
        chart.getProducts().forEach((key, val) -> {
            items.add(new ChartItemDto(key, val));
        });
        cost = chart.getCost();
    }
}
