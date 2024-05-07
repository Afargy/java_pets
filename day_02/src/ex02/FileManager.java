package ex02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
    WorkingDirectory wd = null;

    FileManager(String path) throws Exception {
        Path dir = Paths.get(path);

        if (!Files.exists(dir)) {
            throw new IllegalArgumentException("Directory doesn't exist");
        }

        if (!Files.isDirectory(dir)) {
            throw new IllegalArgumentException("Path isn't directory");
        }

        wd = new WorkingDirectory(dir);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input = null;

        while (!(input = scanner.nextLine()).equals("exit")) {
            try {
                if (input.startsWith("ls")) {
                    wd.ls();
                } else if (input.startsWith("cd")) {
                    wd.cd(input.substring(2).trim());
                } else if (input.startsWith("mv")) {
                    wd.mv(input.substring(2).trim());
                } else {
                    System.out.println("Command not found: " + input);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

}
