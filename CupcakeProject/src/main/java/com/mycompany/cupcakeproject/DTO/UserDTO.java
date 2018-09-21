package com.mycompany.cupcakeproject.DTO;

import com.mycompany.cupcakeproject.CustomerOrAdmin;

public class UserDTO {

    int id, balance;

    String name, username, password, email;

    CustomerOrAdmin customerOrAdmin;

    public UserDTO(int id, int balance, String name, String username, String password, String email, CustomerOrAdmin customerOrAdmin) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
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
    
    public String getEmail() {
        return email;
    }

    public CustomerOrAdmin getCustomerOrAdmin() {
        return customerOrAdmin;
    }

}
