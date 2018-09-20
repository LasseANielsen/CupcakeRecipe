package com.mycompany.cupcakeproject;

public class Product {

    int id, order_id, toppings_id, bottom_id, cart_id;

    public Product(int id, int order_id, int toppings_id, int bottom_id, int cart_id) {
        this.id = id;
        this.order_id = order_id;
        this.toppings_id = toppings_id;
        this.bottom_id = bottom_id;
        this.cart_id = cart_id;
    }

    public int getId() {
        return id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getToppings_id() {
        return toppings_id;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public int getCart_id() {
        return cart_id;
    }

}
