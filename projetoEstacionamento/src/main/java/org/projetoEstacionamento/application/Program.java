package org.projetoEstacionamento.application;

import org.projetoEstacionamento.dao.VeiculoDAO;
import org.projetoEstacionamento.entities.Veiculo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1. Adicionar um veículo");
                System.out.println("2. Listar todos os veículos");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (option) {
                    case 1:
                        // Adicionar um veículo
                        System.out.print("Digite a placa do veículo: ");
                        String placa = scanner.nextLine();
                        System.out.print("Digite o tipo do veículo (Mensalista/Avulso): ");
                        String tipo = scanner.nextLine();
                        System.out.print("Digite a categoria do veículo (Carro/Moto/etc.): ");
                        String categoria = scanner.nextLine();

                        VeiculoDAO.adicionarVeiculo(placa, tipo, categoria);
                        System.out.println("Veículo adicionado com sucesso!");
                        break;

                    case 2:
                        // Listar todos os veículos
                        try {
                            VeiculoDAO veiculoDAO = new VeiculoDAO();
                            List<Veiculo> veiculos = veiculoDAO.listarVeiculos();

                            System.out.println("Veículos no banco de dados:");
                            for (Veiculo veiculo : veiculos) {
                                System.out.println("Placa: " + veiculo.getPlaca() + ", Tipo: " + veiculo.getTipo() + ", Categoria: " + veiculo.getCategoria());
                            }
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar veículos: " + e.getMessage());
                        }
                        break;

                    case 0:
                        // Sair do programa
                        System.out.println("Saindo do programa...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
    }
}
