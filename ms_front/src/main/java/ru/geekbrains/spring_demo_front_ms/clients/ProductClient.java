package ru.geekbrains.spring_demo_front_ms.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.geekbrains.spring_demo_router_lib.dto.ProductListDto;

@FeignClient(name = "product-service", url = "localhost:8191/api/v1")
public interface ProductClient {
    @GetMapping("/products")
    ProductListDto getProducts();
}
