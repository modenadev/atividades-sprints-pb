package org.projetoEstacionamento.dao;

import org.projetoEstacionamento.DB.DatabaseConnection;
import org.projetoEstacionamento.entities.Ticket;

import java.sql.*;
import java.util.*;

public class TicketsDAO {

    private static final double VALOR_MINUTO = 0.10;
    private static final double VALOR_MINIMO = 5.00;
    private static final double VALOR_MENSALISTA = 250.00;

    public static void registrarEntrada(String placa, String tipoVeiculo, int cancelaEntrada) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO tickets (placa, tipo, hora_entrada, cancela_entrada) VALUES (?, ?, NOW(), ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, placa);
                stmt.setString(2, tipoVeiculo);
                stmt.setInt(3, cancelaEntrada);
                stmt.executeUpdate();
            }
        }
    }

    public static void registrarSaida(String placa, int cancelaSaida) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE tickets SET hora_saida = NOW(), cancela_saida = ? WHERE placa = ? AND hora_saida IS NULL";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, cancelaSaida);
                stmt.setString(2, placa);
                stmt.executeUpdate();
            }

            Ticket ticket = getTicket(placa);
            if (ticket != null) {
                double valor = calcularValor(ticket);
                atualizarValor(ticket.getId(), valor);
            }
        }
    }

    private static Ticket getTicket(String placa) throws SQLException {
        return new Ticket();
    }

    private static double calcularValor(Ticket ticket) {
        long tempoEstacionado = ticket.getHoraSaida().getTime() - ticket.getHoraEntrada().getTime();
        double minutos = (tempoEstacionado / 1000.0) / 60.0;
        double valor = minutos * VALOR_MINUTO;
        if (valor < VALOR_MINIMO) {
            valor = VALOR_MINIMO;
        }
        return valor;
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
