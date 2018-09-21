package com.mycompany.cupcakeproject;

import com.mycompany.cupcakeproject.DTO.UserDTO;

public class LoginValidator {

    Controller c = new Controller();

    public boolean validateUsername(String username, String password) {

        if (username == null || username.isEmpty()) {
            return false;
        }
        if (username.contains(";")) {
            return false;
        }
        UserDTO user = c.getUserByName(username);
        if (user != null) {
            return false;
        }

        return validatePassword(username, password, user);
    }

    private boolean validatePassword(String username, String password, UserDTO user) {

        if (password == null || password.isEmpty()) {
            return false;
        }
        if (password.contains(";")) {
            return false;
        }
        if (!password.equals(user.getPassword())) {
            return false;
        }

        return true;
    }
}
