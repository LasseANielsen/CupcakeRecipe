package com.mycompany.cupcakeproject.DAO;
import com.mycompany.cupcakeproject.DBConnector;
import com.mycompany.cupcakeproject.DTO.BottomDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BottomDAO {

    public BottomDTO getPriceByPrice(int id) {
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
}