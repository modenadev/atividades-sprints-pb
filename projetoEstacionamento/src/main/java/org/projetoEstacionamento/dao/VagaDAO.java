package org.projetoEstacionamento.dao;

import org.projetoEstacionamento.entities.Vaga;
import org.projetoEstacionamento.entities.VeiculoComum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VagaDAO {

    private static Connection connect() throws SQLException {
        // Configura a conexão com o banco de dados MySQL
        String url = "jdbc:mysql://localhost:3306/estacionamento";
        String user = "root";
        String password = "ruan1234";
        return DriverManager.getConnection(url, user, password);
    }

    // Adiciona uma nova vaga com o número, categoria e status
    public static void adicionarVaga(int numero, String tipo, String status) throws SQLException {
        String sql = "INSERT INTO vagas (numero, tipo, status) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            stmt.setString(2, tipo);
            stmt.setString(3, status);  // 'status' deve ser 'Livre' ou 'Ocupada'
            stmt.executeUpdate();
        }
    }

    public void liberarVaga(int vagaId) throws SQLException {
        String sql = "UPDATE vagas SET status = 'Livre', veiculo_id = NULL WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vagaId);
            stmt.executeUpdate();
        }
    }
    public Vaga obterVagaPorId(int vagaId) throws SQLException {
        String sql = "SELECT * FROM vagas WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vagaId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Vaga vaga = new Vaga();
                vaga.setNumero(rs.getInt("numero"));
                vaga.setStatus(rs.getString("status")); // status como String
                // O veiculo_id pode ser usado para obter o objeto Veiculo, se necessário
                return vaga;
            }
        }
        return null;
    }

    public List<Vaga> listarVagas() throws SQLException {
        List<Vaga> vagas = new ArrayList<>();
        String sql = "SELECT * FROM vagas";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vaga vaga = new Vaga();
                vaga.setNumero(rs.getInt("numero"));
                vaga.setStatus(rs.getString("status")); // status como String
                vagas.add(vaga);
            }
        }
        return vagas;
    }
}
