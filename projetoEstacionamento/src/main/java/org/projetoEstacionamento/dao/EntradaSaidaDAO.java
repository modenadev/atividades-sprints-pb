package org.projetoEstacionamento.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EntradaSaidaDAO {

    private static Connection connect() throws SQLException {
        // Configura a conexão com o banco de dados MySQL
        String url = "jdbc:mysql://localhost:3306/estacionamento";
        String user = "root";
        String password = "ruan1234";
        return DriverManager.getConnection(url, user, password);
    }




}
