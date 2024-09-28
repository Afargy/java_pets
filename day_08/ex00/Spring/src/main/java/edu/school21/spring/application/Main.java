package edu.school21.spring.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.school21.spring.services.printer.Printer;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "context.xml");

        Printer printer = context.getBean("printerWithPrefix", Printer.class);
        printer.print("Hello!");

        Printer printerDT = context.getBean("printerWithDateTime",
                Printer.class);
        printerDT.print("Hello!");

        ((AbstractApplicationContext) context).close();
    }
}
