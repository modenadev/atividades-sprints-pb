package application;

import db.DB;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {
        System.out.println("Projeto");

        Connection conn = DB.getConnection();
        DB.closeConnection();

    }
}
