package org.projetoEstacionamento.dao;

import org.projetoEstacionamento.entities.VeiculoMensalista;

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


    public List<VeiculoMensalista> listarVeiculosMensalistas() throws SQLException {
        List<VeiculoMensalista> veiculos  = new ArrayList<>();
        String sql = "SELECT * FROM mensalistas";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VeiculoMensalista veiculo = new VeiculoMensalista();
                veiculo.setPlacaMensalista(rs.getString("placa"));
                veiculos.add(veiculo);
            }
        }
        return veiculos;
    }
}


