package ru.geekbrains.spring_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_demo.model.HiProduct;

@Repository
public interface ProductRepository extends JpaRepository<HiProduct, Integer> {

}
