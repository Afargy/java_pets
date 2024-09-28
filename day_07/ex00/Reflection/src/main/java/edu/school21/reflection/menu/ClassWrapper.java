package edu.school21.reflection.menu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.StringJoiner;

public class ClassWrapper {
    private Class<?> clazz;

    public ClassWrapper(Class<?> clazz) {
        this.clazz = clazz;
    }

    public void printFields() {
        for (Field elem : clazz.getDeclaredFields()) {
            System.out.println("\t" + elem.getType().getSimpleName() + " "
                    + elem.getName());
        }
    }

    public void printMethods() {
        for (Method elem : clazz.getDeclaredMethods()) {
            StringJoiner joiner = new StringJoiner(", ", "(", ")");

            for (Class<?> param : elem.getParameterTypes()) {
                joiner.add(param.getSimpleName());
            }

            System.out.println("\t" + elem.getReturnType().getSimpleName() + " "
                    + elem.getName() + joiner.toString());
        }
    }

    public Constructor<?> getParameterizedConstructor() {
        Constructor<?> result = null;
        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor<?> elem : constructors) {
            if (elem.getParameterCount() > 0) {
                result = elem;
                break;
            }
        }

        return result;
    }

    public Field getField(String name) throws Exception {
        return clazz.getDeclaredField(name);
    }

    public Object createObject(Object[] param) throws Exception {
        return getParameterizedConstructor().newInstance(param);
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void updateField(Field field, String value, Object object)
            throws Exception {
        field.setAccessible(true);
        field.set(object, value);
        field.setAccessible(false);
    }

    public Method getMethodByName(String name) {
        Method method = null;

        for (Method elem : clazz.getDeclaredMethods()) {
            if (elem.getName().equals(name)) {
                method = elem;
            }
        }

        return method;
    }

}
