package com.mycompany.cupcakeproject;

import com.mycompany.cupcakeproject.DTO.UserDTO;
import org.apache.commons.validator.routines.EmailValidator;

public class RegisterValidator {

    Controller c = new Controller();

    /**
     * Checks to see if the current user tries to use valid data to create a new
     * user.
     *
     * @param username the username which will go through some test to see if it
     * is valid or not
     * @return the boolean value of the username validation.
     */
    public boolean validateUsername(String username) {
        int min = 4, max = 45;
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (username.contains(";")) {
            return false;
        }
        if (username.length() < min || username.length() > max) {
            return false;
        }
        UserDTO user = c.getUserByUsername(username);
        if (user != null) {
            return false;
        }

        return true;
    }

    /**
     * Checks to see if the current user tries to use valid data to create a new
     * user.
     *
     * @param password the password which will go through some test to see if it
     * is valid or not
     * @return the boolean value of the passwords validation.
     */
    public boolean validatePassword(String password) {
        int min = 4, max = 45;
        if (password == null || password.isEmpty()) {
            return false;
        }
        if (password.contains(";")) {
            return false;
        }
        if (password.length() < min || password.length() > max) {
            return false;
        }

        return true;
    }

    public boolean validateEmail(String email) {
        int min = 6, max = 200;
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (email.contains(";")) {
            return false;
        }
        if (email.length() < min || email.length() > max) {
            return false;
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            return false;
        }
        UserDTO user = c.getUserByEmail(email);
        if (user != null) {
            return false;
        }

        return true;
    }

}
