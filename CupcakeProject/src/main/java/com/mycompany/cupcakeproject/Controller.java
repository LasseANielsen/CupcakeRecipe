package com.mycompany.cupcakeproject;

import com.mycompany.cupcakeproject.DAO.UserDAO;
import com.mycompany.cupcakeproject.DTO.UserDTO;

public class Controller {

    UserDAO userDAO = new UserDAO();

    public UserDTO getUserById(int id) {
        UserDTO DTO = userDAO.getUserById(id);
        return DTO;
    }

    public UserDTO getUserByName(String username) {
        UserDTO DTO = userDAO.getUserByUsername(username);
        return DTO;
    }

    public UserDTO getUserByEmail(String email) {
        UserDTO DTO = userDAO.getUserByEmail(email);
        return DTO;
    }
}
