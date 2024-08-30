package org.projetoEstacionamento.dao;

import org.projetoEstacionamento.DB.DatabaseConnection;
import org.projetoEstacionamento.entities.Ticket;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class TicketsDAO {

    private static final double VALOR_MINUTO = 0.10;
    private static final double VALOR_MINIMO = 5.00;
    private static final double VALOR_MENSALISTA = 250.00;

    public static void registrarEntrada(String placa, int cancelaEntrada) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO tickets (placa, hora_entrada, cancela_entrada) VALUES (?, NOW(), ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, placa);
                stmt.setInt(2, cancelaEntrada);
                stmt.executeUpdate();
            }
        }
    }

    public static boolean verificarEntrada(String placa) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT COUNT(*) FROM tickets WHERE placa = ? AND hora_saida IS NULL";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, placa);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) > 0;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    public static void registrarSaida(String placa, int cancelaSaida) throws SQLException {
        Ticket ticket = buscarTicketPorPlaca(placa); // Supondo que você tenha um método para buscar o ticket
        if (ticket == null) {
            throw new SQLException("Ticket não encontrado para a placa: " + placa);
        }

        // Atualiza a hora de saída no banco de dados
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE tickets SET hora_saida = NOW(), cancela_saida = ? WHERE placa = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, cancelaSaida);
                stmt.setString(2, placa);
                stmt.executeUpdate();
            }
        }

        // Atualiza o objeto ticket
        ticket.setHoraSaida(new Date()); // Define a hora de saída com a hora atual
        double valor = calcularValor(ticket); // Calcula o valor a ser pago
        System.out.println("Valor a ser pago: R$ " + valor);
    }

    private static Ticket buscarTicketPorPlaca(String placa) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM tickets WHERE placa = ? AND hora_saida IS NULL";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, placa);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Ticket ticket = new Ticket();
                        ticket.setPlaca(rs.getString("placa"));
                        ticket.setHoraEntrada(rs.getTimestamp("hora_entrada"));
                        ticket.setHoraSaida(rs.getTimestamp("hora_saida"));
                        // Preencher outros campos do Ticket, se necessário
                        return ticket;
                    } else {
                        return null; // Ticket não encontrado
                    }
                }
            }
        }
    }

    private static Ticket getTicket(String placa) throws SQLException {
        return new Ticket();
    }

    public static double calcularValor(Ticket ticket) {
        if (ticket.getHoraEntrada() == null || ticket.getHoraSaida() == null) {
            throw new IllegalArgumentException("Hora de entrada ou saída não pode ser nula");
        }

        long tempoEstacionadoMillis = ticket.getHoraSaida().getTime() - ticket.getHoraEntrada().getTime();
        long tempoEstacionadoMinutos = tempoEstacionadoMillis / (1000 * 60);

        double valor = tempoEstacionadoMinutos * 0.10; // Valor por minuto
        return Math.max(valor, 5.00); // Valor mínimo de R$ 5,00
    }

    private static void atualizarValor(int id, double valor) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE tickets SET valor = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDouble(1, valor);
                stmt.setInt(2, id);
                stmt.executeUpdate();
            }
        }
    }
}
