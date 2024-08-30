package org.projetoEstacionamento.dao;

import org.projetoEstacionamento.DB.DatabaseConnection;
import org.projetoEstacionamento.entities.Vaga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VagaDAO {


    public static boolean verificarVagaDisponivel(String tipo) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM vagas WHERE tipo = ? AND ocupada = FALSE LIMIT 1";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, tipo);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
        }
    }

    public static void atualizarVaga(int numero, boolean ocupada) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE vagas SET ocupada = ? WHERE numero = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setBoolean(1, ocupada);
                stmt.setInt(2, numero);
                stmt.executeUpdate();
            }
        }
    }
}
