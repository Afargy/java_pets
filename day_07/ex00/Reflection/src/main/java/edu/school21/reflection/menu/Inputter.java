package edu.school21.reflection.menu;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Inputter {
    private Scanner scanner = new Scanner(System.in);
    private ClassesSet set;
    private ClassWrapper clazz = null;

    public Inputter(ClassesSet set) {
        this.set = set;
    }

    public ClassWrapper readClassName() {
        Class<?> temp = null;

        while (temp == null) {
            String input = scanner.nextLine();

            temp = set.returnClass(input);

            if (temp == null) {
                System.out.println("Error: no [" + input + "] class name");
            }
        }

        clazz = new ClassWrapper(temp);

        return clazz;
    }

    public Object[] readParams(ClassWrapper clazz) {
        Object[] params = null;
        int parCount = clazz.getParameterizedConstructor().getParameterCount();
        Field[] fields = clazz.getClazz().getDeclaredFields();

        params = new Object[parCount];

        for (int i = 0; i < parCount; ++i) {
            System.out.println(fields[i].getName() + ":");
            params[i] = scanner.nextLine();
        }

        return params;
    }

    public Field readFieldName() {
        Field field = null;

        while (field == null) {
            try {
                field = clazz.getField(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Error: no [" + field + "] field name");
            }
        }

        return field;
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public Method readMethodName() {
        Method method = null;

        while (method == null) {
            method = clazz.getMethodByName(scanner.nextLine());

            if (method == null) {
                System.out.println("Error: no [" + method + "] field name");
            }
        }

        return method;
    }

}
