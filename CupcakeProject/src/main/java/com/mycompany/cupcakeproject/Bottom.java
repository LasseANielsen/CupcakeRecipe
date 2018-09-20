package com.mycompany.cupcakeproject;

public class Bottom {

    int bottoms_id, price;
    String name;

    public Bottom(int bottoms_id, int price, String name) {
        this.bottoms_id = bottoms_id;
        this.price = price;
        this.name = name;
    }

    public int getBottoms_id() {
        return bottoms_id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
