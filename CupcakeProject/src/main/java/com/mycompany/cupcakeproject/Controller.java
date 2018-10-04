package com.mycompany.cupcakeproject;

import com.mycompany.cupcakeproject.DAO.BottomDAO;
import com.mycompany.cupcakeproject.DAO.ToppingsDAO;
import com.mycompany.cupcakeproject.DAO.UserDAO;
import com.mycompany.cupcakeproject.DTO.BottomDTO;
import com.mycompany.cupcakeproject.DTO.ToppingsDTO;
import com.mycompany.cupcakeproject.DTO.UserDTO;

public class Controller {

    UserDAO userDAO = new UserDAO();
    ToppingsDAO topDAO = new ToppingsDAO();
    BottomDAO botDAO = new BottomDAO();

    /**
     * This method is going into our UserDAO class to retrive a specific userDTO
     * (Data Transfer Object) from our database.
     *
     * @param id is the specific parameter that we specify in out mysql
     * statement.
     * @return a userDTO which contains all the data from the specific user.
     */
    public UserDTO getUserById(int id) {
        UserDTO DTO = userDAO.getUserById(id);
        return DTO;
    }

    /**
     * This method is going into our UserDAO class to retrive a specific userDTO
     * (Data Transfer Object) from our database.
     *
     * @param username is the specific parameter that we specify in out mysql
     * statement.
     * @return a userDTO which contains all the data from the specific user.
     */
    public UserDTO getUserByUsername(String username) {
        UserDTO DTO = userDAO.getUserByUsername(username);
        return DTO;
    }

    /**
     * This method is going into our UserDAO class to retrive a specific userDTO
     * (Data Transfer Object) from our database.
     *
     * @param email is the specific parameter that we specify in out mysql
     * statement.
     * @return a userDTO which contains all the data from the specific user.
     */
    public UserDTO getUserByEmail(String email) {
        UserDTO DTO = userDAO.getUserByEmail(email);
        return DTO;
    }

    /**
     * This method is going into our ToppingsDAO class to retrive a specific
     * ToppingsDTO (Data Transfer Object) from our database.
     *
     * @param name is the specific parameter that we specify in out mysql
     * statement.
     * @return a ToppingsDTO which contains all the data from the specific
     * topping.
     */
    public ToppingsDTO getToppingByName(String name) {
        ToppingsDTO DTO = topDAO.getPriceByName(name);
        return DTO;
    }

    /**
     * This method is going into our BottomDAO class to retrive a specific
     * BottomDTO (Data Transfer Object) from our database.
     *
     * @param name is the specific parameter that we specify in out mysql
     * statement.
     * @return a BottomDTO which contains all the data from the specific bottom.
     */
    public BottomDTO getBottomByName(String name) {
        BottomDTO DTO = botDAO.getPriceByName(name);
        return DTO;
    }

    /**
     * Creates a new user in the database with the specific parameters.
     *
     * @param email user's email.
     * @param username user's username.
     * @param password user's password.
     * @param balance user's cash.
     */
    public void newUser(String email, String username, String password, int balance) {
        userDAO.createUser(email, username, password, balance);
    }
}
