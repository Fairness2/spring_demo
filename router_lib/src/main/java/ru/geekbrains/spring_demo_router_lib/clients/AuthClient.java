package ru.geekbrains.spring_demo_router_lib.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.spring_demo_router_lib.dto.ProductListDto;

@FeignClient(name = "auth-service", url = "localhost:8192/api/v1")
public interface AuthClient {
    @GetMapping("/user/{id}")
    ProductListDto getUser(@PathVariable Integer id);
}
