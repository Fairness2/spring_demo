package ru.geekbrains.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.geekbrains.spring_demo.exceptions.ProductNotFoundException;
import ru.geekbrains.spring_demo.model.dto.CartDto;
import ru.geekbrains.spring_demo.model.entity.Cart;
import ru.geekbrains.spring_demo.model.entity.HiProduct;
import ru.geekbrains.spring_demo.repositories.ProductRepository;

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
        HiProduct product = productRepository.getById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Продукт для добавления в корзину не найден");
        }
        cart.add(product, count);

        return cart.get(product);
    }

    public Integer remove(int productId, int count) {
        HiProduct product = productRepository.getById(productId);
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
