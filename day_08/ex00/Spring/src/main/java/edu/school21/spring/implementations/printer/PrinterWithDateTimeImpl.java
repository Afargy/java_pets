package edu.school21.spring.implementations.printer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import edu.school21.spring.services.printer.Printer;
import edu.school21.spring.services.renderer.Renderer;

public class PrinterWithDateTimeImpl implements Printer {
    private Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String message) {
        renderer.sendToConsole(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                        .format(LocalDateTime.now()) + " " + message);
    }
}
