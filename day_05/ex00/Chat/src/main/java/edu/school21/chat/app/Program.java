package edu.school21.chat.app;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/java_day_05";
        String user = "postgres";
        String password = "yyy";

        try (Connection connection = DriverManager.getConnection(url, user,
                password); Statement statement = connection.createStatement()) {

            System.out.println("Подключение к базе данных выполнено успешно!");

            statement.executeUpdate(readQueryFromFile(
                    Program.class.getResourceAsStream("/schema.sql")));

            statement.executeUpdate(readQueryFromFile(
                    Program.class.getResourceAsStream("/data.sql")));

            printTable(statement.executeQuery("SELECT * FROM chat.user"));
            printTable(statement.executeQuery("SELECT * FROM chat.message"));
            printTable(statement.executeQuery("SELECT * FROM chat.chatroom"));

        } catch (SQLException e) {
            System.out.println(
                    "Ошибка подключения к базе данных: " + e.getMessage());
        }

    }

    private static String readQueryFromFile(InputStream stream) {
        StringBuilder query = new StringBuilder();

        try (Scanner scanner = new Scanner(stream)) {

            while (scanner.hasNextLine()) {
                query.append(scanner.nextLine());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return query.toString();
    }

    private static void printTable(ResultSet results) throws SQLException {
        System.out.println(results.getMetaData().getTableName(1));
        printTableHeader(results.getMetaData());
        printTableBody(results);

    }

    private static void printTableHeader(ResultSetMetaData meta)
            throws SQLException {
        String header = String.format("|%-3s", "Row");

        for (int i = 1; i <= meta.getColumnCount(); ++i) {
            header += String.format("|%-"
                    + getValidatedSize(meta.getColumnDisplaySize(i)) + "s",
                    meta.getColumnName(i));
        }

        header += "|";

        System.out.println(header);

    }

    private static void printTableBody(ResultSet results) throws SQLException {
        while (results.next()) {
            String line = String.format("|%-3d", results.getRow());
            ResultSetMetaData meta = results.getMetaData();

            for (int i = 1; i <= meta.getColumnCount(); ++i) {
                line += String.format("|%-"
                        + getValidatedSize(meta.getColumnDisplaySize(i)) + "s",
                        results.getObject(i).toString());
            }

            line += "|";

            System.out.println(line);
        }
    }

    private static int getValidatedSize(int size) {
        int maxSize = 26;

        return (size > maxSize) ? maxSize : size;
    }

}
