package edu.school21.processors;

import java.io.FileWriter;

public class Writer {
    public void writeToFile(String file, String data) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.append(data);
            writer.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
