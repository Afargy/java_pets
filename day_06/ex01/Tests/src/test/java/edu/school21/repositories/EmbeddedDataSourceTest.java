package edu.school21.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

class EmbeddedDataSourceTest {
    private EmbeddedDatabase ds;

    @BeforeEach
    void init() {
        this.ds = new EmbeddedDatabaseBuilder().addScript("schema.sql")
                .addScript("data.sql").build();
    }

    @Test
    void testDataSourceConnection() throws SQLException {
        try (Connection connection = ds.getConnection()) {
            assertNotNull(connection, "Connection failed");
        }
    }
}
