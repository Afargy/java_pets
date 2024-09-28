package edu.school21.chat.app;

import java.util.Optional;
import java.util.Scanner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

public class Program {

    public static void main(String[] args) {
        MessagesRepositoryJdbcImpl mesSearcher = new MessagesRepositoryJdbcImpl(
                getDataSource());
        Scanner scanner = new Scanner(System.in);
        String scanned = "";
        Long id = null;

        while (!scanned.equals("exit")) {
            Optional<Message> mes;

            if (scanner.hasNextLong()) {
                id = scanner.nextLong();
                mes = mesSearcher.findById(id);

                mes.ifPresent(t -> System.out.println(mes.get()));

            } else {
                scanned = scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static HikariDataSource getDataSource() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/java_day_05");
        config.setUsername("postgres");
        config.setPassword("yyy");

        return new HikariDataSource(config);
    }
}
