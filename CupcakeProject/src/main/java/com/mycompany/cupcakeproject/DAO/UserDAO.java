package com.mycompany.cupcakeproject.DAO;

import com.mycompany.cupcakeproject.CustomerOrAdmin;
import com.mycompany.cupcakeproject.DBConnector;
import com.mycompany.cupcakeproject.DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

    /**
     * Connects to the database and retrive the specific user by the id
     * parameter.
     *
     * @param id user id.
     * @return a copy of an user from the database.
     */
    public UserDTO getUserById(int id) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM `User` "
                    + "WHERE `id` = '" + id + "';";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                int user_id = Integer.parseInt(res.getString("Id"));
                String name = res.getString("Name");
                String username = res.getString("Username");
                String password = res.getString("Password");
                CustomerOrAdmin privileges = CustomerOrAdmin.valueOf(res.getString("C/A"));
                int balance = Integer.parseInt(res.getString("Balance"));
                String email = res.getString("Email");

                return new UserDTO(user_id, balance, name, username, password, email, privileges);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
        return null;
    }

    /**
     * Connects to the database and retrive the specific user by the username
     * parameter.
     *
     * @param username user username.
     * @return a copy of an user from the database.
     */
    public UserDTO getUserByUsername(String username) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM `User` "
                    + "WHERE `Username` = '" + username + "';";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                int id = Integer.parseInt(res.getString("Id"));
                String name = res.getString("Name");
                String user_username = res.getString("Username");
                String password = res.getString("Password");
                CustomerOrAdmin privileges = CustomerOrAdmin.valueOf(res.getString("C/A"));
                int balance = Integer.parseInt(res.getString("Balance"));
                String email = res.getString("Email");

                return new UserDTO(id, balance, name, user_username, password, email, privileges);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
        return null;
    }

    /**
     * The method which executes the mysql query string and create a user and
     * stores it in the database.
     *
     * @param email users email.
     * @param username users username.
     * @param password users password.
     * @param balance users cash.
     */
    public void createUser(String email, String username, String password, int balance) {
        try {
            Connection c = new DBConnector().getConnection();
            int id = getNextAvailableId();
            String name = "user" + id;
            String query
                    = "INSERT INTO `User`(`Id`,`Name`,`Username`,`Password`,`C/A`,`Balance`,`Email`) VALUES "
                    + "(?,?,?,?,?,?,?);";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.setString(5, "C");
            stmt.setInt(6, balance);
            stmt.setString(7, email);

            stmt.executeUpdate();
            //stmt.executeQuery(query);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
    }

    private int getNextAvailableId() {
        int i = 1;
        for (i = 1; i < Integer.MAX_VALUE; i++) {
            UserDTO user = getUserById(i);
            if (user == null) {
                break;
            }
        }
        return i;
    }

    public UserDTO getUserByEmail(String email) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM `User` "
                    + "WHERE `email` = '" + email + "';";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                int id = Integer.parseInt(res.getString("Id"));
                String name = res.getString("Name");
                String username = res.getString("Username");
                String password = res.getString("Password");
                CustomerOrAdmin privileges = CustomerOrAdmin.valueOf(res.getString("C/A"));
                int balance = Integer.parseInt(res.getString("Balance"));
                String user_email = res.getString("Email");

                return new UserDTO(id, balance, name, username, password, user_email, privileges);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
        return null;
    }
}
