package edu.school21.spring.implementations.printer;

import edu.school21.spring.services.printer.Printer;
import edu.school21.spring.services.renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private String prefix = "";
    private Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String message) {
        renderer.sendToConsole(prefix + " " + message);
    }

    public void setPrefix(String prefix) {
        if (prefix != null) {
            this.prefix = prefix;
        }
    }
}
