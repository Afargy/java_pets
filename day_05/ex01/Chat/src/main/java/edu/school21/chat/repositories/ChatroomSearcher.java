package edu.school21.chat.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import edu.school21.chat.models.Chatroom;

public class ChatroomSearcher {
    private DataSource ds;

    public ChatroomSearcher(DataSource ds) {
        this.ds = ds;
    }

    public Chatroom findById(Long id) {
        Chatroom room = null;

        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM chat.chatroom WHERE id = " + id;
            ResultSet results = statement.executeQuery(query);

            results.next();

            room = new Chatroom(id, results.getString("name"), null, null);

        } catch (Exception e) {
            System.out.println("No chatroom with id " + id);
        }

        return room;
    }

}
