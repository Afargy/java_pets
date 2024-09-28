package edu.school21.models;

import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private Integer price;

    public Product(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product info: ID is " + id + ", name is " + name + ", price is "
                + price;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if ((obj == null) || obj.getClass() != this.getClass()) {
            result = false;
        } else if (obj == this) {
            result = true;
        } else {
            Product other = (Product) obj;

            result = id.equals(other.id) && name.equals(other.name)
                    && price.equals(other.price);
        }

        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

}
