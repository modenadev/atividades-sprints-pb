package org.projetoEstacionamento.application;

import org.projetoEstacionamento.dao.TicketsDAO;
import org.projetoEstacionamento.dao.VagaDAO;
import org.projetoEstacionamento.entities.Vaga;

import java.sql.SQLException;
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
                    //Veículo entrando
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Digite o tipo do veículo (Carro, Moto, Caminhao, ServicoPublico): ");
                    String tipo = scanner.nextLine();
                    System.out.print("O veículo é mensalista? (sim/não): ");
                    boolean mensalista = scanner.nextLine().equalsIgnoreCase("sim");

                    // Verifica se o veículo já está no estacionamento
                    if (TicketsDAO.verificarEntrada(placa)) {
                        System.out.println("Veículo já está no estacionamento. Registre a saída antes de tentar entrar novamente.");
                    } else {
                        int cancelaEntrada = getCatracaEntrada(tipo, mensalista);
                        if (cancelaEntrada == -1) {
                            System.out.println("Veículo de serviço público tem acesso livre.");
                        } else if (VagaDAO.verificarVagaDisponivel(tipo)) {
                            TicketsDAO.registrarEntrada(placa, cancelaEntrada);
                            VagaDAO.atualizarVaga(getVagaDisponivel(tipo), true);
                        } else {
                            System.out.println("Não há vagas disponíveis para o tipo de veículo.");
                        }
                    }
                    break;

                case 2:
                    //Veículo saindo
                    System.out.print("Digite a placa do veículo: ");
                    String placaSaida = scanner.nextLine();

                    String tipoSaida = getTipoVeiculoPorPlaca(placaSaida);

                    int cancelaSaida = getCatracaSaida(tipoSaida);
                    if (cancelaSaida == -1) {
                        System.out.println("Veículo de serviço público tem acesso livre.");
                    } else {
                        TicketsDAO.registrarSaida(placaSaida, cancelaSaida);
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static int getCatracaEntrada(String tipo, boolean mensalista) {
        switch (tipo) {
            case "Carro":
                return mensalista ? 1 : 2; // Exemplo: mensalista usa cancela 1, avulso usa cancela 2
            case "Moto":
                return mensalista ? 5 : 6; // Exemplo: mensalista usa cancela 5, avulso usa cancela 6
            case "Caminhao":
                return 1; // Caminhões de entrega usam a cancela 1
            case "ServicoPublico":
                return -1; // Veículos de serviço público têm acesso livre, não precisa de cancela
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido.");
        }
    }

    private static int getCatracaSaida(String tipo) {
        switch (tipo) {
            case "Carro":
            case "Moto":
            case "Caminhao":
                return 6; // Exemplo: todos saem pela cancela 6
            case "ServicoPublico":
                return -1; // Veículos de serviço público têm acesso livre
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido.");
        }
    }

    private static int getVagaDisponivel(String tipo) {
        // Implementar a lógica para obter a vaga disponível
        return 0;
    }

    private static String getTipoVeiculoPorPlaca(String placa) {
        // Implementar a lógica para obter o tipo de veículo com base na placa
        // Isso pode envolver consultar o banco de dados
        return "Carro"; // Substitua com a lógica real
    }
}
