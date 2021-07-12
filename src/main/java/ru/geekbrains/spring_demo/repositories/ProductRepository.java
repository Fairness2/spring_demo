package ru.geekbrains.spring_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_demo.model.HiProduct;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<HiProduct, Integer> {
    List<HiProduct> findAllByCostGreaterThanEqual(Integer min);
    List<HiProduct> findAllByCostBetween(Integer min, Integer max);
    @Query("SELECT p FROM HiProduct p WHERE p.cost >= :min AND LOWER(p.title) LIKE LOWER(:like)")
    List<HiProduct> findAllByCostGreaterThanEqualAndTitleLike(@Param("min") Integer min, @Param("like") String like);
    @Query("SELECT p FROM HiProduct p WHERE p.cost BETWEEN :min AND :max AND LOWER(p.title) LIKE LOWER(:like)")
    List<HiProduct> findAllByCostBetweenAndTitleLike(@Param("min") Integer min, @Param("max") Integer max, @Param("like") String like);
}
