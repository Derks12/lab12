package com.example.Base_Conciertos.Daos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DaoBase {
    public Connection getConection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String username = "root";
        String password = "root";
        String database = "conciertos";
        String url = "jdbc:mysql://localhost:3306/" + database;

        return DriverManager.getConnection(url, username, password);
        //return DriverManager.getConnection("jdbc:mysql://34.132.80.85:3306/"+database,"root","V?pY@\\L7zUj>|^4@");

    }
}
