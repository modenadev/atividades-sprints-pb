package org.projetoEstacionamento.dao;

import org.projetoEstacionamento.DB.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;

public class EntradaSaidaDAO {

    private static Connection connect() throws SQLException {
        // Configura a conexão com o banco de dados MySQL
        String url = "jdbc:mysql://localhost:3306/estacionamento";
        String user = "root";
        String password = "ruan1234";
        return DriverManager.getConnection(url, user, password);
    }

    public static boolean registrarEntrada(String placa, int cancela_entrada) throws SQLException {
        String sql = "insert into entradas_saidas (placa, cancela_entrada, hora_entrada) values (?,?,?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            stmt.setInt(2, cancela_entrada);
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.executeUpdate();
            return true;
        }

    }

    public static boolean registrarSaida(String placa, int cancela_saida) throws SQLException {
        String sql = "update entradas_saidas set hora_saida = ? where placa = ? and hora_saida is not null ";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, placa);
            stmt.setInt(2, cancela_saida);
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.executeUpdate();
            return true;
        }
    }

    public static boolean validarEntrada(String placa, String tipoDoVeiculo) throws SQLException {
        switch (tipoDoVeiculo) {
            case "Caminhão":
                return registrarEntrada(placa, 1);
            case "Moto":
                return registrarEntrada(placa, 5);
            case "Serviço Público":
                return true; // Acesso livre
            case "Carro":
            default:
                return registrarEntrada(placa, (int) (Math.random() * 5) + 1);
        }
    }

    public static boolean validarSaida(String placa, String tipoDoVeiculo) throws SQLException {
        switch (tipoDoVeiculo) {
            case "Caminhão":
                return registrarEntrada(placa, (int) (Math.random() * 5) + 6);
            case "Moto":
                return registrarSaida(placa, 10);
            case "Serviço Público":
                return true; // Sai por qualquer uma
            case "Carro":
            default:
                return registrarEntrada(placa, (int) (Math.random() * 5) + 1);
        }
    }


}
