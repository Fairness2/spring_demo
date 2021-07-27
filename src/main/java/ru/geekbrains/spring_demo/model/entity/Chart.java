package ru.geekbrains.spring_demo.model.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Chart {
    private final Map<HiProduct, Integer> products;

    public Chart() {
        products = new HashMap<>();
    }

    public void add(HiProduct product) {
        this.add(product, 1);
    }

    public void add(HiProduct product, int count) {
        if (!products.containsKey(product)) {
            products.put(product, count);
        }
        else {
            products.compute(product, (key, value) -> value + count);
        }
    }

    public void remove(HiProduct product) {
        this.remove(product, 1);
    }

    public Integer remove(HiProduct product, int count) {
        if (!products.containsKey(product)) {
            return 0;
        }

        int val = products.get(product);
        if ((val - count) <= 0) {
            products.remove(product);
            return 0;
        }
        else {
            val -= count;
            products.put(product, val);
            return val;
        }
    }

    public int getCost() {
        AtomicInteger cost = new AtomicInteger();
        products.forEach((key, val) -> {
            cost.addAndGet(val * key.getCost());
        });

        return cost.get();
    }

    public Integer get(HiProduct product) {
        return products.get(product);
    }
}
