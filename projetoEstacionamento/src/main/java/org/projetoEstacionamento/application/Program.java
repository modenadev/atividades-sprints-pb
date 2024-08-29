package org.projetoEstacionamento.application;

import org.projetoEstacionamento.dao.EntradaSaidaDAO;
import org.projetoEstacionamento.dao.VagaDAO;
import org.projetoEstacionamento.dao.VeiculoDAO;
import org.projetoEstacionamento.entities.Vaga;
import org.projetoEstacionamento.entities.VeiculoMensalista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1. Veiculo entrando");
                System.out.println("2. Veiculo saindo");
                System.out.println("3. Adicionar um veículo mensalista");
                System.out.println("4. Listar todos os veículos mensalistas");
                System.out.println("5. Listar vagas disponveis no sistema");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (option) {

                    case 1:
                        //Veiculo entrando

                        String tipoDoVeiculo;
                        System.out.println("Escolha o tipo do veiculo: ");
                        System.out.println("1. Carro");
                        System.out.println("2. Moto");
                        System.out.println("3. Caminhao");
                        int optionTipoVeiculo = scanner.nextInt();
                        scanner.nextLine();

                        switch (optionTipoVeiculo) {

                            case 1:
                                tipoDoVeiculo = "Carro";
                                break;
                            case 2:
                                tipoDoVeiculo = "Moto";
                                break;
                            case 3:
                                tipoDoVeiculo = "Caminhao";
                                break;
                            default:
                                tipoDoVeiculo = "Não existe";
                        }

                        System.out.print("Digite a placa do veiculo: ");
                        String placa = scanner.nextLine();
                        System.out.println("Ele é Mensalista ou Avulso: ");
                        String tipo = scanner.nextLine();

                        EntradaSaidaDAO.validarEntrada(placa, tipoDoVeiculo);
                        break;

                    case 2:

                        // Adicionar um veículo mensalista
                        System.out.print("Digite a placa do veículo: ");
                        String placaMensalista = scanner.nextLine();

                        VeiculoDAO.adicionarVeiculoMensalista(placaMensalista);
                        break;

                    case 3:

                        // Listar todos os veículos mensalistas
                        try {
                            VeiculoDAO veiculoDAO = new VeiculoDAO();
                            List<VeiculoMensalista> veiculos = veiculoDAO.listarVeiculosMensalistas();

                            System.out.println("Veículos mensalistas no banco de dados:");
                            for (VeiculoMensalista veiculo : veiculos) {
                                System.out.println("Placa: " + veiculo.getPlacaMensalista());
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
