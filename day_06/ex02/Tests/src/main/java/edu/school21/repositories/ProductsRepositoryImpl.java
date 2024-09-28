package edu.school21.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import edu.school21.models.Product;

public class ProductsRepositoryImpl implements ProductsRepository {
    private DataSource ds;

    public ProductsRepositoryImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Product> findAll() {
        List<Product> all = new ArrayList<Product>();

        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "select * from products.product";
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                all.add(new Product(results.getLong("id"),
                        results.getString("name"), results.getInt("price")));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return all;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<Product> product = Optional.empty();

        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "select * from products.product where \"id\"=" + id;
            ResultSet results = statement.executeQuery(query);

            if (results.next()) {
                product = Optional.of(new Product(results.getLong("id"),
                        results.getString("name"), results.getInt("price")));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return product;
    }

    @Override
    public void update(Product product) {
        try (Connection connection = ds.getConnection()) {
            String query = "UPDATE products.product SET "
                    + "\"name\" = ?, \"price\" = ? WHERE \"id\" = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setLong(3, product.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void save(Product product) {
        try (Connection connection = ds.getConnection()) {
            String query = "INSERT INTO products.product "
                    + "(\"name\", \"price\") VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());

            if (statement.executeUpdate() > 0) {
                ResultSet results = statement.getGeneratedKeys();

                results.next();
                product.setId(results.getLong("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ds.getConnection()) {
            String query = "DELETE FROM products.product WHERE \"id\" = " + id;
            Statement statement = connection.createStatement();

            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
