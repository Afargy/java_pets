package edu.school21.chat.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import edu.school21.chat.models.User;

public class UserSearcher {
    private DataSource ds;

    public UserSearcher(DataSource ds) {
        this.ds = ds;
    }

    public User findById(Long id) {
        User user = null;

        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM chat.user WHERE id = " + id;
            ResultSet results = statement.executeQuery(query);

            results.next();
            user = new User(id, results.getString("login"),
                    results.getString("password"), null, null);

        } catch (Exception e) {
            System.out.println("No user with id " + id);
        }

        return user;
    }

}
