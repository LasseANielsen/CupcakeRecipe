package com.mycompany.cupcakeproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

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

    public UserDTO getUserByUsername(String username) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM `User` "
                    + "WHERE `username` = '" + username + "';";
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

    public void createUser(String email, String username, String password, int balance) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            int id = getNextAvailableId();
            String name = "user" + id;
            String query
                    = "INSERT INTO `User`(`id`,`name`,`username`,`password`,`C/A`,`balance`,`email`) VALUES"
                    + "('" + id + "','" + name + "','" + username + "','" + password + "','C',+'" + balance + "','" + email + "')";

            ResultSet res = stmt.executeQuery(query);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
    }

    private int getNextAvailableId() {
        int i = 0;
        for (i = 0; i < Integer.MAX_VALUE; i++) {
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
