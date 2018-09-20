package com.mycompany.cupcakeproject;

public class CartDTO {

    int id, user_id;

    public CartDTO(int id, int user_id) {
        this.id = id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

}
