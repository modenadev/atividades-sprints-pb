package org.projetoEstacionamento.service;

import org.projetoEstacionamento.entities.Veiculo;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class Estacionamento {

    private static final double VALOR_POR_MINUTO = 0.10;
    private static final double COBRANCA_MINIMA = 5.00;
    private static final double TAXA_MENSALISTA = 250.00;

    private Connection connect() throws SQLException {
        // Configura a conexão com o banco de dados MySQL
        String url = "jdbc:mysql://localhost:3306/estacionamento";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public void registrarEntrada(Veiculo veiculo) throws SQLException {
        Connection conn = connect();
        String sql = "INSERT INTO veiculos (placa, tipo, categoria) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getTipo());
            stmt.executeUpdate();
        }
    }

    public void registrarSaida(String placa) throws SQLException {
        Connection conn = connect();
        String sql = "SELECT hora_entrada, vaga_id FROM tickets WHERE placa = ? AND hora_saida IS NULL";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                LocalDateTime horaEntrada = rs.getTimestamp("hora_entrada").toLocalDateTime();
                int vagaId = rs.getInt("vaga_id");
                double valorPago = calcularValor(horaEntrada);

                String updateSql = "UPDATE tickets SET hora_saida = NOW(), valor_pago = ? WHERE placa = ? AND hora_saida IS NULL";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setDouble(1, valorPago);
                    updateStmt.setString(2, placa);
                    updateStmt.executeUpdate();
                }

                // Atualizar o status da vaga
                String vagaUpdateSql = "UPDATE vagas SET ocupada = FALSE, veiculo_id = NULL WHERE id = ?";
                try (PreparedStatement vagaStmt = conn.prepareStatement(vagaUpdateSql)) {
                    vagaStmt.setInt(1, vagaId);
                    vagaStmt.executeUpdate();
                }
            }
        }
    }

    private double calcularValor(LocalDateTime horaEntrada) {
        long minutos = Duration.between(horaEntrada, LocalDateTime.now()).toMinutes();
        double valor = minutos * VALOR_POR_MINUTO;
        return Math.max(valor, COBRANCA_MINIMA);
    }
}
