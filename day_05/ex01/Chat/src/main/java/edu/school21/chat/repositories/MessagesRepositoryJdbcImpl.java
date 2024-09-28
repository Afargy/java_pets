package edu.school21.chat.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javax.sql.DataSource;

import edu.school21.chat.models.Message;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private DataSource ds;
    private UserSearcher userSearcher;
    private ChatroomSearcher chatroomSearcher;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
        userSearcher = new UserSearcher(ds);
        chatroomSearcher = new ChatroomSearcher(ds);
    }

    @Override
    public Optional<Message> findById(Long id) {
        Optional<Message> message = Optional.empty();

        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM chat.message WHERE id = " + id;
            ResultSet results = statement.executeQuery(query);

            results.next();
            message = Optional.ofNullable(new Message(results.getLong("id"),
                    userSearcher.findById(results.getLong("author")),
                    chatroomSearcher.findById(results.getLong("room")),
                    results.getString("text"),
                    results.getTimestamp("date_and_time")));
        } catch (SQLException e) {
            System.out.println("No message with id " + id);
        }

        return message;
    }

}
