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

    public UserDTO getUserById(int id) {
        UserDTO DTO = userDAO.getUserById(id);
        return DTO;
    }

    public UserDTO getUserByUsername(String username) {
        UserDTO DTO = userDAO.getUserByUsername(username);
        return DTO;
    }

    public UserDTO getUserByEmail(String email) {
        UserDTO DTO = userDAO.getUserByEmail(email);
        return DTO;
    }

    public ToppingsDTO getToppingByName(String name) {
        ToppingsDTO DTO = topDAO.getPriceByName(name);
        return DTO;
    }
    
    public BottomDTO getBottomByName(String name) {
        BottomDTO DTO = botDAO.getPriceByName(name);
        return DTO;
    }
    
    public void newUser(String email, String username, String password, int balance) { 
        userDAO.createUser(email, username, password, balance);
    } 
}
