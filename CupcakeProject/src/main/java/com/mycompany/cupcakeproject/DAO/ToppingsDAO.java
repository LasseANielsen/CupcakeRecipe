package com.mycompany.cupcakeproject.DAO;

import com.mycompany.cupcakeproject.DBConnector;
import com.mycompany.cupcakeproject.DTO.ToppingsDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ToppingsDAO {

    /**
     * Connects to the database and retrive the specific topping by the id
     * parameter.
     *
     * @param id topping id.
     * @return a copy of a topping from the database.
     */
    public ToppingsDTO getPriceById(int id) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM `Toppings` "
                    + "WHERE `id` = '" + id + "';";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                int toppingsId = Integer.parseInt(res.getString("id"));
                int toppingsPrice = res.getInt("price");
                String toppingsName = (res.getString("name"));

                return new ToppingsDTO(toppingsId, toppingsPrice, toppingsName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
        return null;
    }

    /**
     * Connects to the database and retrive the specific topping by the name
     * parameter.
     *
     * @param name topping name.
     * @return a copy of a topping from the database.
     */
    public ToppingsDTO getPriceByName(String name) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM `Toppings` "
                    + "WHERE `name` = '" + name + "';";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                int toppingsId = Integer.parseInt(res.getString("id"));
                int toppingsPrice = res.getInt("price");
                String toppingsName = (res.getString("name"));

                return new ToppingsDTO(toppingsId, toppingsPrice, toppingsName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
        return null;
    }
}
