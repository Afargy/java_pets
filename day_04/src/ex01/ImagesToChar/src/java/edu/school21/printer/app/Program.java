package edu.school21.printer.app;

import edu.school21.printer.logic.ArgumentsParser;
import edu.school21.printer.logic.BmpPrinter;

public class Program {
    public static void main(String[] args) {
        try {
            ArgumentsParser arguments = new ArgumentsParser(args);
            BmpPrinter printer = new BmpPrinter();

            printer.print(arguments);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
