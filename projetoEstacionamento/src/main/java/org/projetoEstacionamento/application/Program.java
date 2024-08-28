package org.projetoEstacionamento.application;

import org.projetoEstacionamento.DB.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Program {

        public static void main(String[] args) throws SQLException {


            Connection con = DatabaseConnection.getConnection();


        }
}
