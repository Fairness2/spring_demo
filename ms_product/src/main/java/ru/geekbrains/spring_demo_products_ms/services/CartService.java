package ru.geekbrains.spring_demo_products_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.geekbrains.spring_demo_core_libs.exceptions.ProductNotFoundException;
import ru.geekbrains.spring_demo_products_ms.model.dto.CartDto;
import ru.geekbrains.spring_demo_products_ms.model.entity.Cart;
import ru.geekbrains.spring_demo_products_ms.model.entity.Product;
import ru.geekbrains.spring_demo_products_ms.repositories.ProductRepository;

import javax.annotation.PostConstruct;

@Service
@SessionScope
public class CartService {
    @Autowired
    private ProductRepository productRepository;

    private Cart cart;

    @PostConstruct
    public void init() {
        cart = new Cart();
    }

    public Integer add(int productId, int count) {
        Product product = productRepository.getById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Продукт для добавления в корзину не найден");
        }
        cart.add(product, count);

        return cart.get(product);
    }

    public Integer remove(int productId, int count) {
        Product product = productRepository.getById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Продукт для добавления в корзину не найден");
        }
        cart.remove(product, count);

        return cart.get(product);
    }

    public CartDto getCart() {
        return new CartDto(cart);
    }
}
