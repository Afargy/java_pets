package edu.school21.reflection;

import java.lang.reflect.Field;

import edu.school21.reflection.menu.ClassWrapper;
import edu.school21.reflection.menu.ClassesSet;
import edu.school21.reflection.menu.Delimiter;
import edu.school21.reflection.menu.Inputter;

public class App {
    private static ClassesSet set = new ClassesSet();
    private static Inputter input = new Inputter(set);
    private static Delimiter delimier = new Delimiter();
    private static ClassWrapper clazz;
    private static Object object;
    private static Field updatedField;
    private static String value;

    public static void main(String[] args) {

        try {
            System.out.println("Classes:");
            set.printAllClasses();
            delimier.print();

            System.out.println("Enter class name:");
            clazz = input.readClassName();
            delimier.print();

            System.out.println("fields:");
            clazz.printFields();

            System.out.println("methods:");
            clazz.printMethods();
            delimier.print();

            System.out.println("Let's create an object.");
            object = clazz.createObject(input.readParams(clazz));
            System.out.println("Object created: " + object.toString());
            delimier.print();

            System.out.println("Enter name of the field for changing:");
            updatedField = input.readFieldName();

            System.out.println("Enter string value:");
            value = input.readLine();

            clazz.updateField(updatedField, value, object);
            System.out.println("Object updated: " + object.toString());
            delimier.print();

            System.out.println("Enter name of the method for call:");
            input.readMethodName();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
