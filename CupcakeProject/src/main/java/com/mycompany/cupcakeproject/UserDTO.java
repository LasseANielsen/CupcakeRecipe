package com.mycompany.cupcakeproject;

public class UserDTO {

    int id, balance;

    String name, username, password;

    CustomerOrAdmin customerOrAdmin;

    public UserDTO(int id, int balance, String name, String username, String password, CustomerOrAdmin customerOrAdmin) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.username = username;
        this.password = password;
        this.customerOrAdmin = customerOrAdmin;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
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
