package edu.school21.reflection.classes;

public class Fruit {
    private String name;
    private String brand;

    public Fruit() {
        name = "Apple";
        brand = "GoldenFruits";
    }

    public Fruit(String firstName, String brand) {
        this.name = firstName;
        this.brand = brand;
    }

    public void firstPublicMethod() {
        System.out.println("First public method called");
    }

    public void secondPublicMethod(String param_1, String param_2) {
        System.out.println("Second public method called. Param #1 is " + param_1
                + ". Param #2 is " + param_2 + ".");
    }

    @Override
    public String toString() {
        return "Class name is " + this.getClass().getSimpleName() + ". "
                + "Name is " + name + ". " + "Brand is " + brand + ".";
    }
}
