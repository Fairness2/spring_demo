package ru.geekbrains.spring_demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_demo.exceptions.InvalidParamsException;
import ru.geekbrains.spring_demo.model.dto.ChartDto;
import ru.geekbrains.spring_demo.services.ChartService;

@RestController
@RequestMapping("api/v1/chart")
@RequiredArgsConstructor
public class ChartController {
    private final ChartService chartService;

    @GetMapping
    public ChartDto getChart() {
        return chartService.getChart();
    }

    @PostMapping
    public Integer addProduct(@RequestParam(required = true, name = "product_id") Integer productId,
                              @RequestParam(defaultValue = "1") Integer count) {
        if (count <= 0 ) {
            throw new InvalidParamsException("Количество не может быть меньше нуля или равно нулю");
        }

        return chartService.add(productId, count);
    }

    @DeleteMapping
    public Integer removeProduct(@RequestParam(required = true, name = "product_id") Integer productId,
                              @RequestParam(defaultValue = "1") Integer count) {
        if (count <= 0 ) {
            throw new InvalidParamsException("Количество не может быть меньше нуля или равно нулю");
        }

        return chartService.remove(productId, count);
    }
}
