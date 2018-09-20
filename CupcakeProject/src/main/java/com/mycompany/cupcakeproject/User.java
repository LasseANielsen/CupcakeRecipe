package com.mycompany.cupcakeproject;

public class User {

    int id;

    String name, username, password;

    CustomerOrAdmin customerOrAdmin;

    public User(int id, String name, String username, String password, CustomerOrAdmin customerOrAdmin) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.customerOrAdmin = customerOrAdmin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public CustomerOrAdmin getCustomerOrAdmin() {
        return customerOrAdmin;
    }

}
