package ru.geekbrains.spring_demo_products_ms;

import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest {
    private MockMvc mvc;
    private static int tempProductId;
    private static final String testTitle = "Test Product";
    private static final String updatedTestTitle = "Updated Test Product";
    private static final int testCost = 100500;
    private static final int updatedTestCost = 100501;
    private static final int testCategoryId = 1;
    private static final int updatedCategoryId = 2;

    @Autowired
    public void setMockMvc(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    @Order(1)
    public void getProductListTest() throws Exception {
        this.mvc.perform(get("/products")
                .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products").isArray())
                .andExpect(jsonPath("$.page").isNumber())
                .andExpect(jsonPath("$.total").isNumber());
    }

    @Test
    @Order(2)
    public void addProductTest() throws Exception {
        JSONObject object = new JSONObject();
        object.put("title", testTitle);
        object.put("cost", testCost);
        object.put("categoryId", testCategoryId);
        String content = object.toString();
        MvcResult result = this.mvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNumber())
                .andReturn();

        tempProductId = Integer.parseInt(result.getResponse().getContentAsString());
    }

    @Test
    @Order(3)
    public void getProductTest() throws Exception {
        this.mvc.perform(get(String.format("/products/%s", tempProductId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.id").value(tempProductId))
                .andExpect(jsonPath("$.title").isString())
                .andExpect(jsonPath("$.title").value(testTitle))
                .andExpect(jsonPath("$.cost").isNumber())
                .andExpect(jsonPath("$.cost").value(testCost))
                .andExpect(jsonPath("$.category.id").isNumber())
                .andExpect(jsonPath("$.category.id").value(testCategoryId))
                .andExpect(jsonPath("$.category.name").isString());
    }

    @Test
    @Order(4)
    public void updateProductTest() throws Exception {
        JSONObject object = new JSONObject();
        object.put("id", tempProductId);
        object.put("title", updatedTestTitle);
        object.put("cost", updatedTestCost);
        object.put("categoryId", updatedCategoryId);
        String content = object.toString();
        this.mvc.perform(put("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNumber());
    }

    @Test
    @Order(5)
    public void getUpdatedProductTest() throws Exception {
        this.mvc.perform(get(String.format("/products/%s", tempProductId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.id").value(tempProductId))
                .andExpect(jsonPath("$.title").isString())
                .andExpect(jsonPath("$.title").value(updatedTestTitle))
                .andExpect(jsonPath("$.cost").isNumber())
                .andExpect(jsonPath("$.cost").value(updatedTestCost))
                .andExpect(jsonPath("$.category.id").isNumber())
                .andExpect(jsonPath("$.category.id").value(updatedCategoryId))
                .andExpect(jsonPath("$.category.name").isString());
    }

    @Test
    @Order(6)
    public void deleteProductTest() throws Exception {
        this.mvc.perform(delete("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", String.valueOf(tempProductId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isBoolean())
                .andExpect(jsonPath("$").value(true));
    }

    @Test
    @Order(7)
    public void getDeletedProductTest() throws Exception {
        this.mvc.perform(get(String.format("/products/%s", tempProductId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
