package org.projetoEstacionamento.application;

import org.projetoEstacionamento.dao.TicketsDAO;
import org.projetoEstacionamento.dao.VagaDAO;
import org.projetoEstacionamento.dao.VeiculoDAO;
import org.projetoEstacionamento.entities.Vaga;
import org.projetoEstacionamento.entities.VeiculoMensalista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        TicketsDAO ticketsDAO = new TicketsDAO();
        VagaDAO vagaDAO = new VagaDAO();

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Veículo entrando");
            System.out.println("2. Veículo saindo");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Digite o tipo do veículo (Carro, Moto, Caminhao, ServicoPublico): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite a cancela de entrada: ");
                    int cancelaEntrada = scanner.nextInt();
                    scanner.nextLine();

                    if (VagaDAO.verificarVagaDisponivel(tipo)) {
                        TicketsDAO.registrarEntrada(placa, tipo, cancelaEntrada);
                        VagaDAO.atualizarVaga(getVagaDisponivel(tipo), true);
                    } else {
                        System.out.println("Não há vagas disponíveis para o tipo de veículo.");
                    }
                    break;

                case 2:
                    System.out.print("Digite a placa do veículo: ");
                    String placaSaida = scanner.nextLine();
                    System.out.print("Digite a cancela de saída: ");
                    int cancelaSaida = scanner.nextInt();
                    scanner.nextLine();

                    TicketsDAO.registrarSaida(placaSaida, cancelaSaida);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static int getVagaDisponivel(String tipo) {
        // Implementar a lógica para obter a vaga disponível
        return 0;
    }
}
