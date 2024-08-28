package org.example;

import org.example.DB.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class testConnection {
    public static void main(String[] args) throws SQLException {


        Connection con = DatabaseConnection.getConnection();



    }
}