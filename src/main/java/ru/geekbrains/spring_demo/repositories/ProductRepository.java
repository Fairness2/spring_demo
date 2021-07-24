package ru.geekbrains.spring_demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_demo.model.entity.HiProduct;

import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepository extends JpaRepository<HiProduct, Integer>, JpaSpecificationExecutor<HiProduct> {
    /*Page<HiProduct> findAllByCostGreaterThanEqual(Integer min, Pageable pageable);
    Page<HiProduct> findAllByCostBetween(Integer min, Integer max, Pageable pageable);
    @Query("SELECT p FROM HiProduct p WHERE p.cost >= :min AND LOWER(p.title) LIKE LOWER(:like)")
    Page<HiProduct> findAllByCostGreaterThanEqualAndTitleLike(@Param("min") Integer min, @Param("like") String like, Pageable pageable);
    @Query("SELECT p FROM HiProduct p WHERE p.cost BETWEEN :min AND :max AND LOWER(p.title) LIKE LOWER(:like)")
    Page<HiProduct> findAllByCostBetweenAndTitleLike(@Param("min") Integer min, @Param("max") Integer max, @Param("like") String like, Pageable pageable);*/
}
