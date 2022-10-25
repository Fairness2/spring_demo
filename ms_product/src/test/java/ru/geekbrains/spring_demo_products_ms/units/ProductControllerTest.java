package ru.geekbrains.spring_demo_products_ms.units;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;
import ru.geekbrains.spring_demo_products_ms.controllers.ProductController;
import ru.geekbrains.spring_demo_products_ms.models.dto.ProductCreateDto;
import ru.geekbrains.spring_demo_products_ms.models.dto.ProductRequestDto;
import ru.geekbrains.spring_demo_products_ms.models.dto.ProductUpdateDto;
import ru.geekbrains.spring_demo_products_ms.models.enitites.Category;
import ru.geekbrains.spring_demo_products_ms.models.enitites.Product;
import ru.geekbrains.spring_demo_products_ms.repositories.specifications.ProductSpecifications;
import ru.geekbrains.spring_demo_products_ms.services.ProductService;
import ru.geekbrains.spring_demo_router_lib.dto.ProductDto;
import ru.geekbrains.spring_demo_router_lib.dto.ProductListDto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootTest(classes = ProductController.class)
@ActiveProfiles("test")
public class ProductControllerTest {
    private ProductController productController;
    @MockBean
    private ProductService productService;

    @Autowired
    private void setProductService(ProductController productController) {
        this.productController = productController;
    }

    @Test
    public void getProductsTest() {
        ProductRequestDto dto = new ProductRequestDto();
        Specification<Product> specification = ProductSpecifications.build(dto);
        int testPage = 1;
        int testPerPage = 5;

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

        Mockito.doReturn(page)
                .when(productService)
                .getAll(1, specification);

        ProductListDto result = productController.getProducts(dto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getPage(), 1);
        Assertions.assertEquals(result.getTotal(), page.getTotalPages());
    }

    @Test
    public void getProductTest() {
        int testId = 5;
        String testTitle = "Test product";
        int testCost = 100500;
        int catId = 1;
        String catTitle = "Test category";
        Product testProduct = new Product();
        testProduct.setId(testId);
        testProduct.setTitle(testTitle);
        testProduct.setCost(testCost);
        testProduct.setCategory(new Category(catId, catTitle));
        Mockito.doReturn(testProduct)
                .when(productService)
                .getOne(testId);

        ProductDto result = productController.getProduct(testId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), testId);
        Assertions.assertEquals(result.getTitle(), testTitle);
        Assertions.assertEquals(result.getCost(), testCost);
        Assertions.assertNotNull(result.getCategory());
        Assertions.assertEquals(result.getCategory().getId(), catId);
        Assertions.assertEquals(result.getCategory().getName(), catTitle);
    }

    @Test
    public void addProductTest() {
        int testId = 5;
        String testTitle = "Test product";
        int testCost = 100500;
        int catId = 1;
        String catTitle = "Test category";
        Product testProduct = new Product();
        testProduct.setTitle(testTitle);
        testProduct.setCost(testCost);
        testProduct.setCategory(new Category(catId, null));

        Product testProduct2 = new Product();
        testProduct2.setId(testId);
        testProduct2.setTitle(testTitle);
        testProduct2.setCost(testCost);
        testProduct2.setCategory(new Category(catId, catTitle));

        Mockito.doReturn(testProduct2)
                .when(productService)
                .add(testProduct);

        ProductCreateDto createDto = new ProductCreateDto(testProduct);

        Integer result = productController.addProduct(createDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result, testId);
    }

    @Test
    public void updateProductTest() {
        int testId = 5;
        String testTitle = "Test product";
        int testCost = 100500;
        int catId = 1;
        String catTitle = "Test category";
        Product testProduct = new Product();
        testProduct.setId(testId);
        testProduct.setTitle(testTitle);
        testProduct.setCost(testCost);
        testProduct.setCategory(new Category(catId, null));

        Mockito.doReturn(testProduct)
                .when(productService)
                .update(testProduct);

        ProductUpdateDto updateDto = new ProductUpdateDto(testProduct);

        Integer result = productController.updateProduct(updateDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result, testId);
    }

    @Test
    public void deleteProductTest() {
        int testId = 5;
        Mockito.doReturn(true)
                .when(productService)
                .delete(testId);

        boolean result = productController.deleteProduct(testId);

        Assertions.assertTrue(result);
    }
}
