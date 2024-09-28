package edu.school21.reflection.classes;

public class Vegetable {
    private String name;
    private String brand;

    public Vegetable() {
        name = "Potato";
        brand = "GreenVegetables";
    }

    public Vegetable(String firstName) {
        this.name = firstName;
        brand = "GreenVegetables";
    }

    public void firstPublicMethod() {
        System.out.println("First public method called");
    }

    public void secondPublicMethod() {
        System.out.println("Second public method called");
    }

    @Override
    public String toString() {
        return "Class name is " + this.getClass().getSimpleName() + ". "
                + "Name is " + name + ". " + "Brand is " + brand + ".";
    }
}
