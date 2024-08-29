package org.projetoEstacionamento.enums;

public enum vehicleEnum {
    CarrosPasseio(2),
    Motos(1),
    Caminhoes(4),
    VeiculosServicoPublico(2);

    private final int quantidadeVagas;

    vehicleEnum(int quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }

    public int getValor() {
        return quantidadeVagas;
    }

    // Método para obter o valor do enum pelo nome //
    public static int getQuantidadeDeVagasPorVeiculo(String veiculo) {
        try {
            return vehicleEnum.valueOf(veiculo).getValor();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Veiculo não encontrado: " + veiculo);
        }
    }
}
