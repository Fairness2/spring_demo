package ru.geekbrains.spring_demo.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_demo.exceptions.ProductNotFoundException;
import ru.geekbrains.spring_demo.model.Product;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        create("Some product 1", 123);
        create("Some product 2", 123);
        create("Some product 3", 123);
    }

    public boolean add(Product product) {
        return productList.add(product);
    }

    public boolean delete(String uuid) {
        Product product = Product.builder()
                .uuid(UUID.fromString(uuid))
                .build();

        return productList.remove(product);
    }

    public List<Product> getAll() {
        return Collections.unmodifiableList(productList);
    }

    public Product getOne(UUID uuid) {
        /*Product product = Product.builder()
                .uuid(uuid)
                .build();
        int index = productList.indexOf(product);
        return index != -1 ? productList.get(index) : null;*/
        Optional<Product> oProduct = productList.stream()
                .filter(product -> product.getUuid().equals(uuid))
                .findFirst();

        return oProduct.orElseThrow(() -> new ProductNotFoundException(String.format("Продукт %s не найден", uuid.toString())));
    }

    public Product create(String title, int cost) {
        Product product = Product.builder()
                .uuid(UUID.randomUUID())
                .title(title)
                .cost(cost)
                .build();

        return productList.add(product) ? product : null;
    }

    public Product update(String uuid, String title, int cost) {
        Product product = Product.builder()
                .uuid(UUID.fromString(uuid))
                .build();
        int index = productList.indexOf(product);
        if (index == -1) {
            return null;
        }
        product = productList.get(index);
        product.setTitle(title);
        product.setCost(cost);
        return product;
    }

    public int size() {
        return productList.size();
    }

    public double avgCost() {
        int cost = productList.stream().mapToInt(Product::getCost).sum();
        return cost / (double) productList.size();
    }


}
