package ru.geekbrains.spring_demo_products_ms.units;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;
import ru.geekbrains.spring_demo_products_ms.models.dto.ProductRequestDto;
import ru.geekbrains.spring_demo_products_ms.models.enitites.Product;
import ru.geekbrains.spring_demo_products_ms.repositories.ProductRepository;
import ru.geekbrains.spring_demo_products_ms.repositories.specifications.ProductSpecifications;
import ru.geekbrains.spring_demo_products_ms.services.ProductService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootTest(classes = ProductService.class)
@ActiveProfiles("test")
public class ProductServiceTest {
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void getAllTest() {
        ProductRequestDto dto = new ProductRequestDto();
        Specification<Product> specification = ProductSpecifications.build(dto);
        Page<Product> page = new Page<Product>() {
            @Override
            public int getTotalPages() {
                return 2;
            }

            @Override
            public long getTotalElements() {
                return 12;
            }

            @Override
            public <U> Page<U> map(Function<? super Product, ? extends U> function) {
                return null;
            }

            @Override
            public int getNumber() {
                return 0;
            }

            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public int getNumberOfElements() {
                return 0;
            }

            @Override
            public List<Product> getContent() {
                return new ArrayList<Product>();
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator<Product> iterator() {
                return null;
            }
        };
        int testPage = 1;
        int testPerPage = 5;
        Mockito.doReturn(page)
                .when(productRepository)
                .findAll(specification, PageRequest.of(testPage - 1,testPerPage));

        Page<Product> result = productService.getAll(testPage, specification);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getTotalPages(), page.getTotalPages());
        Assertions.assertEquals(result.getTotalElements(), page.getTotalElements());
    }

    @Test
    public void getOneTest() {
        int testId = 5;
        String testTitle = "Test product";
        int testCost = 100500;
        Product testProduct = new Product();
        testProduct.setId(testId);
        testProduct.setTitle(testTitle);
        testProduct.setCost(testCost);
        Optional<Product> optionalProduct = Optional.of(testProduct);
        Mockito.doReturn(optionalProduct)
                .when(productRepository)
                .findById(testId);

        Product result = productService.getOne(testId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), testId);
        Assertions.assertEquals(result.getTitle(), testTitle);
        Assertions.assertEquals(result.getCost(), testCost);
    }

    @Test
    public void addTest() {
        int testId = 5;
        String testTitle = "Test product";
        int testCost = 100500;

        Product testProduct = new Product();
        testProduct.setTitle(testTitle);
        testProduct.setCost(testCost);

        Product testProduct2 = new Product();
        testProduct2.setId(testId);
        testProduct2.setTitle(testTitle);
        testProduct2.setCost(testCost);

        Mockito.doReturn(testProduct2)
                .when(productRepository)
                .save(testProduct);

        Product result = productService.add(testProduct);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), testProduct2.getId());
        Assertions.assertEquals(result.getTitle(), testProduct.getTitle());
        Assertions.assertEquals(result.getCost(), testProduct.getCost());
    }

    @Test
    public void updateTest() {
        int testId = 5;
        String testTitle2 = "Test product2";
        int testCost = 100500;

        Product testProduct = new Product();
        testProduct.setId(testId);
        testProduct.setTitle(testTitle2);
        testProduct.setCost(testCost);

        Mockito.doReturn(testProduct)
                .when(productRepository)
                .save(testProduct);

        Product result = productService.update(testProduct);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), testProduct.getId());
        Assertions.assertEquals(result.getTitle(), testTitle2);
        Assertions.assertEquals(result.getCost(), testProduct.getCost());
    }

    @Test
    public void deleteTest() {
        int testId = 5;
        Mockito.doReturn(false)
                .when(productRepository)
                .existsById(testId);
        boolean result = productService.delete(testId);

        Assertions.assertTrue(result);
    }
}
