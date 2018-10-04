package com.mycompany.cupcakeproject;

import com.mycompany.cupcakeproject.DTO.UserDTO;

public class LoginValidator {

    Controller c = new Controller();

    /**
     * Checks to see if the current user uses a valid user from the database.
     *
     * @param username the username which will be compared to the database.
     * @param password the password which will be send into validatePassword.
     * @return
     */
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

    /**
     * Checks to see if the user are using the correct password with that
     * username they also gave.
     *
     * @param password the password which will be compared to the one in the
     * database.
     * @param user the user which contains the correct password.
     * @return
     */
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
