package com.example.shtrauch.restaurant;

/**
 * Created by ororo on 7/30/2016.
 */
public class Dish
{
    private String name;
    private float price;
    private DishType type;

    public Dish(String name, float price, DishType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }
}
