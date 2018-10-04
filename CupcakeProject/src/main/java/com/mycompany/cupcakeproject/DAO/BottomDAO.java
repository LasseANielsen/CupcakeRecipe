package com.mycompany.cupcakeproject.DAO;

import com.mycompany.cupcakeproject.DBConnector;
import com.mycompany.cupcakeproject.DTO.BottomDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BottomDAO {

    /**
     * Connects to the database and retrive the specific bottom by the id
     * parameter.
     *
     * @param id bottoms id.
     * @return a copy of a bottom from the database.
     */
    public BottomDTO getPriceById(int id) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM `Bottom` "
                    + "WHERE `id` = '" + id + "';";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                int bottomId = Integer.parseInt(res.getString("id"));
                int bottomPrice = res.getInt("price");
                String bottomName = (res.getString("name"));

                return new BottomDTO(bottomId, bottomPrice, bottomName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
        return null;
    }

    /**
     * Connects to the database and retrive the specific bottom by the name
     * parameter.
     *
     * @param name bottoms name.
     * @return a copy of a bottom from the database.
     */
    public BottomDTO getPriceByName(String name) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM `Bottom` "
                    + "WHERE `name` = '" + name + "';";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                int bottomId = Integer.parseInt(res.getString("id"));
                int bottomPrice = res.getInt("price");
                String bottomName = (res.getString("name"));

                return new BottomDTO(bottomId, bottomPrice, bottomName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
        return null;
    }
}
