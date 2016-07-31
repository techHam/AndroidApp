package com.example.shtrauch.restaurant;

/**
 * Created by ororo on 7/30/2016.
 */

import java.io.Serializable;

public class MenuItem implements Serializable
{
    private String name;
    private float price;
    private DishType type;

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

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
