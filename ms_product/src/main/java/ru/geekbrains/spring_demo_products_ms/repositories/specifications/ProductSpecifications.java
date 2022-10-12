package ru.geekbrains.spring_demo_products_ms.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.spring_demo_products_ms.models.dto.ProductRequestDto;
import ru.geekbrains.spring_demo_products_ms.models.enitites.Product;
import java.util.List;

public class ProductSpecifications {
    public static Specification<Product> build(ProductRequestDto requestDto) {
        Specification<Product> specification = Specification.where(null);
        if (requestDto.getMinCost() != null) {
            specification = specification.and(ProductSpecifications.costGreaterThanEqual(requestDto.getMinCost()));
        }
        if (requestDto.getMaxCost() != null) {
            specification = specification.and(ProductSpecifications.costLessThanEqual(requestDto.getMaxCost()));
        }
        if (requestDto.getTitle() != null) {
            specification = specification.and(ProductSpecifications.titleLike(requestDto.getTitle()));
        }
        if (requestDto.getIds() != null && requestDto.getIds().size() > 0) {
            specification = specification.and(ProductSpecifications.idIn(requestDto.getIds()));
        }

        if (requestDto.getCategories() != null && requestDto.getCategories().size() > 0) {
            specification = specification.and(ProductSpecifications.categoryIn(requestDto.getCategories()));
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

    private static Specification<Product> idIn(List<Integer> ids) {
        return ((root, criteriaQuery, criteriaBuilder) -> root.get("id").in(ids));
    }

    private static Specification<Product> categoryIn(List<Integer> categoryIds) {
        return ((root, criteriaQuery, criteriaBuilder) -> root.get("category").in(categoryIds));
    }
}
