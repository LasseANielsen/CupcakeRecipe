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
        UserDTO user = c.getUserByUsername(username);
        if (user == null) {
            return false;
        }
        return validatePassword(password, user);
    }

    private boolean validatePassword(String password, UserDTO user) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        if (password.contains(";")) {
            return false;
        }
        return password.equals(user.getPassword());
    }
}

/*
select *
from `user`
where `username` = ? and `password` = ?;
returnere 0 linjer hvis de ikke mactcher (bool)
*/
