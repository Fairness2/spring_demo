package ru.geekbrains.spring_demo_front_ms.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.geekbrains.spring_demo_router_lib.dto.CartDto;
import ru.geekbrains.spring_demo_front_ms.models.entities.Cart;
import ru.geekbrains.spring_demo_front_ms.models.entities.Product;

import javax.annotation.PostConstruct;

@Service
@SessionScope
public class CartService {

    private Cart cart;

    @PostConstruct
    public void init() {
        cart = new Cart();
    }

    public Integer add(int productId, int count) {
        /*Product product = productRepository.getById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Продукт для добавления в корзину не найден");
        }
        cart.add(product, count);

        return cart.get(product);*/
        return null;
    }

    public Integer remove(int productId, int count) {
        /*Product product = productRepository.getById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Продукт для добавления в корзину не найден");
        }
        cart.remove(product, count);

        return cart.get(product);*/
        return null;
    }

    public CartDto getCart() {
        //return new CartDto(cart);
        return null;
    }
}
