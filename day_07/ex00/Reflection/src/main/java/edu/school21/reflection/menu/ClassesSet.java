package edu.school21.reflection.menu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import edu.school21.reflection.classes.Fruit;
import edu.school21.reflection.classes.Vegetable;

public class ClassesSet {
    private Set<Class<?>> set = new HashSet<>(
            Arrays.asList(Fruit.class, Vegetable.class));

    public void printAllClasses() {

        for (Class<?> elem : set) {
            System.out.println(" - " + elem.getSimpleName());
        }
    }

    public Class<?> returnClass(String name) {
        Class<?> clazz = null;

        for (Class<?> elem : set) {
            if (name.equals(elem.getSimpleName())) {
                clazz = elem;
                break;
            }
        }

        return clazz;
    }
}
