package ru.geekbrains.spring_demo_products_ms.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.geekbrains.spring_demo_products_ms.models.enitites.Product;

import java.util.List;

public class ProductSpecifications {
    public static Specification<Product> build(MultiValueMap<String, String> params) {
        Specification<Product> specification = Specification.where(null);

        if (params.containsKey("min") && !params.getFirst("min").isBlank()) {
            specification = specification.and(ProductSpecifications.costGreaterThanEqual(Integer.parseInt(params.getFirst("min"))));
        }
        if (params.containsKey("max") && !params.getFirst("max").isBlank()) {
            specification = specification.and(ProductSpecifications.costLessThanEqual(Integer.parseInt(params.getFirst("max"))));
        }
        if (params.containsKey("like") && !params.getFirst("like").isBlank()) {
            specification = specification.and(ProductSpecifications.titleLike(params.getFirst("like")));
        }
        if (params.containsKey("ids") && params.get("ids").size() > 0) {
            specification = specification.and(ProductSpecifications.idIn(params.get("ids")));
        }

        return specification;
    }

    private static Specification<Product> costGreaterThanEqual(int min) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), min));
    }

    private static Specification<Product> costLessThanEqual(int max) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), max));
    }

    private static Specification<Product> titleLike(String titlePart) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(
                        criteriaBuilder.lower(root.get("title")),
                        String.format("%%%s%%", titlePart).toLowerCase()
                )
        );
    }

    private static Specification<Product> idIn(List<String> ids) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.in(root.get("id").in(ids)));
    }
}
