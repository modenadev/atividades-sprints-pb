package org.projetoEstacionamento.application;

import org.projetoEstacionamento.DB.DatabaseConnection;
import org.projetoEstacionamento.dao.VagaDAO;
import org.projetoEstacionamento.entities.Vaga;
import org.projetoEstacionamento.entities.Veiculo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Program {

        public static void main(String[] args) throws SQLException {


            VagaDAO vagaDAO = new VagaDAO();

            try {
                // Adicionando vagas
                for (int i = 1; i <= 10; i++) {
                    VagaDAO.adicionarVaga(i, "Caminhao", "Ocupada");
                }
                System.out.println("Vagas adicionadas.");

                // Listando todas as vagas
                List<Vaga> vagas = vagaDAO.listarVagas();
                for (Vaga vaga : vagas) {
                    System.out.println("Vaga número: " + vaga.getNumero() + ", Ocupada: " + vaga.isOcupada());
                }

                // Suponha que você tenha um veiculo
                Veiculo veiculo = new Veiculo();
                veiculo.setId(1); // Defina o ID do veículo conforme o banco de dados

                // Ocupar uma vaga
                vagaDAO.ocuparVaga(1, veiculo);
                System.out.println("Vaga 1 ocupada.");

                // Listar todas as vagas novamente
                vagas = vagaDAO.listarVagas();
                for (Vaga vaga : vagas) {
                    System.out.println("Vaga número: " + vaga.getNumero() + ", Ocupada: " + vaga.isOcupada());
                }

                // Liberar uma vaga
                vagaDAO.liberarVaga(1);
                System.out.println("Vaga 1 liberada.");

                // Listar todas as vagas novamente
                vagas = vagaDAO.listarVagas();
                for (Vaga vaga : vagas) {
                    System.out.println("Vaga número: " + vaga.getNumero() + ", Ocupada: " + vaga.isOcupada());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


}

