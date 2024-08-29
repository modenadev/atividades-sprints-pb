package org.projetoEstacionamento.application;

import org.projetoEstacionamento.dao.VagaDAO;
import org.projetoEstacionamento.dao.VeiculoDAO;
import org.projetoEstacionamento.entities.Vaga;
import org.projetoEstacionamento.entities.VeiculoComum;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1. Adicionar um veículo");
                System.out.println("2. Adicionar um veículo mensalista");
                System.out.println("3. Listar todos os veículos");
                System.out.println("4. Listar vagas disponveis no sistema");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (option) {
                    case 1:
                        // Adicionar um veículo comum
                        System.out.print("Digite a placa do veículo: ");
                        String placa = scanner.nextLine();
                        System.out.print("Digite o tipo do veículo (Mensalista/Avulso): ");
                        String tipo = scanner.nextLine();
                        System.out.print("Digite a categoria do veículo (Carro/Moto/etc.): ");
                        String categoria = scanner.nextLine();

                        VeiculoDAO.adicionarVeiculoComum(placa, tipo, categoria);
                        break;

                    case 2:
                        // Adicionar um veículo mensalista
                        System.out.print("Digite a placa do veículo: ");
                        String placaMensalista = scanner.nextLine();

                        VeiculoDAO.adicionarVeiculoMensalista(placaMensalista);
                        break;

                    case 3:
                        // Listar todos os veículos
                        try {
                            VeiculoDAO veiculoDAO = new VeiculoDAO();
                            List<VeiculoComum> veiculos = veiculoDAO.listarVeiculos();

                            System.out.println("Veículos no banco de dados:");
                            for (VeiculoComum veiculo : veiculos) {
                                System.out.println("Placa: " + veiculo.getPlaca() + ", Tipo: " + veiculo.getTipo() + ", Categoria: " + veiculo.getCategoria());
                            }
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar veículos: " + e.getMessage());
                        }
                        break;

                    case 4:
                        //Listar vagas
                        try{
                            VagaDAO vagaDAO = new VagaDAO();
                            List<Vaga> vagas = vagaDAO.listarVagas();

                            System.out.println("Vagas disponiveis no estacionamento: ");
                            for (Vaga vaga : vagas) {
                                System.out.println( "A vaga é: " + vaga.getNumero() + "A vaga está: " + vaga.getStatus() + " e é de categoria: " + vaga.getCategoria());
                            }

                        }catch (SQLException e) {
                            System.out.println("Erro ao listar vagas: " + e.getMessage());
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
