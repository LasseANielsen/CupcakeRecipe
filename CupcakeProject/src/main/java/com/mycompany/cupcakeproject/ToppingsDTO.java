package com.mycompany.cupcakeproject;

public class ToppingsDTO {

    int toppings_id, price;
    String name;

    public int getToppings_id() {
        return toppings_id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public ToppingsDTO(int toppings_id, int price, String name) {
        this.toppings_id = toppings_id;
        this.price = price;
        this.name = name;
    }
}
