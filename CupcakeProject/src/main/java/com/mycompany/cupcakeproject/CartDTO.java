package com.mycompany.cupcakeproject;

public class CartDTO {

    int id, user_cart_id;

    public CartDTO(int id, int user_id) {
        this.id = id;
        this.user_cart_id = user_id;
    }

    public int getId() {
        return id;
    }

    public int getUser_cart_id() {
        return user_cart_id;
    }

}
