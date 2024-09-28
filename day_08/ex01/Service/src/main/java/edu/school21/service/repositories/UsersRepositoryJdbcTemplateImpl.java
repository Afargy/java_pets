package edu.school21.service.repositories;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.school21.service.models.User;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private JdbcTemplate jdbc;

    public UsersRepositoryJdbcTemplateImpl(DataSource ds) {
        jdbc = new JdbcTemplate(ds);
    }

    @Override
    public List<User> findAll() {
        return jdbc.query("SELECT * FROM users.user", (rs,
                rowNum) -> new User(rs.getLong("id"), rs.getString("email")));
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = Optional.empty();

        try {
            user = Optional.of(
                    jdbc.queryForObject("SELECT * FROM users.user WHERE id = ?",
                            (rs, rowNum) -> new User(rs.getLong("id"),
                                    rs.getString("email")),
                            id));
        } catch (EmptyResultDataAccessException e) {
            System.err.println(e.getMessage());
            System.err.println("No user with entered id");
        }

        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> user = Optional.empty();

        try {
            user = Optional.of(jdbc.queryForObject(
                    "SELECT * FROM users.user WHERE email = ?",
                    (rs, rowNum) -> new User(rs.getLong("id"),
                            rs.getString("email")),
                    email));
        } catch (EmptyResultDataAccessException e) {
            System.err.println(e.getMessage());
            System.err.println("No user with entered email");
        }

        return user;
    }

    @Override
    public void save(User user) {
        try {
            jdbc.update("INSERT INTO users.user (email) VALUES (?)",
                    user.getEmail());
        } catch (DuplicateKeyException e) {
            System.err.println("ERROR: email already exists");
        } catch (DataIntegrityViolationException e) {
            System.err.println("ERROR: email is null");
        } catch (Exception e) {
            System.err.println("ERROR: null User");
        }
    }

    @Override
    public void update(User user) {
        try {
            jdbc.update("UPDATE users.user SET email = ? WHERE id = ?",
                    user.getEmail(), user.getId());
        } catch (DuplicateKeyException e) {
            System.err.println("ERROR: email already exists");
        } catch (DataIntegrityViolationException e) {
            System.err.println("ERROR: email is null");
        } catch (Exception e) {
            System.err.println("ERROR: null User");
        }
    }

    @Override
    public void delete(Long id) {
        jdbc.update("DELETE FROM users.user WHERE id = ?", id);
    }

    public void execute(String query) {
        jdbc.execute(query);
    }

}
