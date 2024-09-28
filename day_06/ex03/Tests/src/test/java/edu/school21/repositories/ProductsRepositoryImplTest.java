package edu.school21.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import edu.school21.models.Product;

class ProductsRepositoryImplTest {
    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = new ArrayList<Product>(
            Arrays.asList(new Product(1l, "product_1", 11),
                    new Product(2l, "product_2", 22),
                    new Product(3l, "product_3", 33),
                    new Product(4l, "product_4", 44),
                    new Product(5l, "product_5", 55)));
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(1l, "product_1",
            11);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(1l, "product_123",
            123);
    final Product EXPECTED_SAVE_PRODUCT = new Product(6l, "product_6", 66);
    private EmbeddedDatabase ds;
    private ProductsRepositoryImpl products;

    @BeforeEach
    void init() {
        ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql").addScript("data.sql").build();

        products = new ProductsRepositoryImpl(ds);
    }

    @Test
    void test_findById_notEmpty() {
        assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, products.findById(1l).get());
    }

    @Test
    void test_findById_Empty() {
        assertEquals(Optional.empty(), products.findById(33l));
    }

    @Test
    void test_findAll() {
        assertEquals(EXPECTED_FIND_ALL_PRODUCTS, products.findAll());
    }

    @Test
    void test_update() {
        products.update(new Product(1l, "product_123", 123));
        assertEquals(EXPECTED_UPDATED_PRODUCT, products.findById(1l).get());
    }

    @Test
    void test_save() {
        products.save(new Product(6l, "product_6", 66));
        assertEquals(EXPECTED_SAVE_PRODUCT, products.findById(6l).get());
    }

    @Test
    void test_delete() {
        products.delete(1l);
        assertEquals(4, (products.findAll().size()));
    }

    @AfterEach
    void afterEach() {
        ds.shutdown();
    }

}
