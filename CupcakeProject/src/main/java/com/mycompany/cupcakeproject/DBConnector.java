package com.mycompany.cupcakeproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    private Connection connection = null;

    //Constants
    private static final String IP = "104.248.26.203";
    private static final String PORT = "3306";
    public static final String DATABASE = "CupcakeDB";
    private static final String USERNAME = "Ryge";
    private static final String PASSWORD = "1234";

    public DBConnector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return this.connection;
    }
}
