package ru.geekbrains.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.geekbrains.spring_demo.exceptions.ProductNotFoundException;
import ru.geekbrains.spring_demo.model.dto.ChartDto;
import ru.geekbrains.spring_demo.model.entity.Chart;
import ru.geekbrains.spring_demo.model.entity.HiProduct;
import ru.geekbrains.spring_demo.repositories.ProductRepository;

import javax.annotation.PostConstruct;

@Service
@SessionScope
public class ChartService {
    @Autowired
    private ProductRepository productRepository;

    private Chart chart;

    @PostConstruct
    public void init() {
        chart = new Chart();
    }

    public Integer add(int productId, int count) {
        HiProduct product = productRepository.getById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Продукт для добавления в корзину не найден");
        }
        chart.add(product, count);

        return chart.get(product);
    }

    public Integer remove(int productId, int count) {
        HiProduct product = productRepository.getById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Продукт для добавления в корзину не найден");
        }
        chart.remove(product, count);

        return chart.get(product);
    }

    public ChartDto getChart() {
        return new ChartDto(chart);
    }
}
