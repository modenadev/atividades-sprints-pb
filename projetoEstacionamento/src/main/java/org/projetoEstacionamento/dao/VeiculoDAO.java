package org.projetoEstacionamento.dao;

import org.projetoEstacionamento.entities.VeiculoComum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    private static Connection connect() throws SQLException {
        // Configura a conexão com o banco de dados MySQL
        String url = "jdbc:mysql://localhost:3306/estacionamento";
        String user = "root";
        String password = "ruan1234";
        return DriverManager.getConnection(url, user, password);
    }

    public static void adicionarVeiculoComum(String placa, String tipo, String categoria) {
        String sql = "INSERT INTO veiculos (placa, tipo, categoria) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            stmt.setString(2, tipo);
            stmt.setString(3, categoria);
            stmt.executeUpdate();
            System.out.println("Veículo adicionado com sucesso!");
        } catch (SQLException e) {
            if (e.getSQLState().equals("22001")) { // O código SQLState para truncamento de dados é 22001
                System.out.println("Erro: A placa excedeu o máximo de caracteres permitido: " + e.getMessage());
            }
            if (e.getSQLState().equals("23000")) { // Código de estado SQL para violação de chave única
                System.out.println("Erro: Veículo com a placa '" + placa + "' já existe.");
            }
        }
    }

    public static void adicionarVeiculoMensalista(String placaMensalista) {
        String sql = "INSERT INTO mensalistas (placa) VALUES (?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placaMensalista);
            stmt.executeUpdate();
            System.out.println("Veículo adicionado com sucesso!");

        } catch (SQLException e) {
            if (e.getSQLState().equals("23000")) { // Código de estado SQL para violação de chave única
                System.out.println("Erro: Veículo mensalista com a placa '" + placaMensalista + "' já existe.");
            }
        }
    }

    public static VeiculoComum buscarVeiculo(String placa) throws SQLException {
        String sql = "SELECT * FROM veiculos WHERE placa = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                VeiculoComum veiculo = new VeiculoComum();
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setTipo(rs.getString("tipo"));
                veiculo.setCategoria(rs.getString("categoria"));
                veiculo.setMensalista(rs.getBoolean("mensalista"));
                return veiculo;

            }
        }
        return null;
    }

    public List<VeiculoComum> listarVeiculos() throws SQLException {
        List<VeiculoComum> veiculos  = new ArrayList<>();
        String sql = "SELECT * FROM veiculos";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VeiculoComum veiculo = new VeiculoComum();
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setTipo(rs.getString("tipo")); // Certifique-se de definir o tipo
                veiculo.setCategoria(rs.getString("categoria")); // status como String
                veiculos.add(veiculo);
            }
        }
        return veiculos;
    }
}


