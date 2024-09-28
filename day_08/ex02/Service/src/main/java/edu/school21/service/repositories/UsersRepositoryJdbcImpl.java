package edu.school21.service.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import edu.school21.service.models.User;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private DataSource ds;

    public UsersRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ds.getConnection();) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users.user");

            while (rs.next()) {
                users.add(new User(rs.getLong("id"), rs.getString("email")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = Optional.empty();

        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM users.user WHERE id = ?");
            ResultSet rs = null;

            statement.setLong(1, id);
            rs = statement.executeQuery();

            if (rs.next()) {
                user = Optional
                        .of(new User(rs.getLong("id"), rs.getString("email")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> user = Optional.empty();

        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users.user WHERE email = ?");
            ResultSet rs = null;

            statement.setString(1, email);
            rs = statement.executeQuery();

            if (rs.next()) {
                user = Optional
                        .of(new User(rs.getLong("id"), rs.getString("email")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return user;
    }

    @Override
    public void save(User user) {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users.user (id, email) VALUES (?, ?)");

            statement.setLong(1, user.getId());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = ds.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users.user SET email = ? WHERE id = ?");

            statement.setString(1, user.getEmail());
            statement.setLong(2, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("DELETE FROM users.user WHERE id = ?");

            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
