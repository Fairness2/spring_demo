package ru.geekbrains.spring_demo.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.geekbrains.spring_demo.model.entity.HiProduct;

public class ProductSpecifications {
    public static Specification<HiProduct> build(MultiValueMap<String, String> params) {
        Specification<HiProduct> specification = Specification.where(null);

        if (params.containsKey("min") && !params.getFirst("min").isBlank()) {
            specification = specification.and(ProductSpecifications.costGreaterThanEqual(Integer.parseInt(params.getFirst("min"))));
        }
        if (params.containsKey("max") && !params.getFirst("max").isBlank()) {
            specification = specification.and(ProductSpecifications.costLessThanEqual(Integer.parseInt(params.getFirst("max"))));
        }
        if (params.containsKey("like") && !params.getFirst("like").isBlank()) {
            specification = specification.and(ProductSpecifications.titleLike(params.getFirst("like")));
        }

        return specification;
    }

    private static Specification<HiProduct> costGreaterThanEqual(int min) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), min));
    }

    private static Specification<HiProduct> costLessThanEqual(int max) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), max));
    }

    private static Specification<HiProduct> titleLike(String titlePart) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(
                        criteriaBuilder.lower(root.get("title")),
                        String.format("%%%s%%", titlePart).toLowerCase()
                )
        );
    }
}
