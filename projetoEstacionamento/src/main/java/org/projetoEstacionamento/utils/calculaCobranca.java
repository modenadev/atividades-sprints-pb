package org.projetoEstacionamento.utils;

import java.util.Date;

public class calculaCobranca {

    private static final double valorMinimo = 5.00;
    private static final double valorPorMinuto = 0.10;

    public double calcularValor(Date horaEntrada, Date horaSaida){

        long tempoEstacionado = horaSaida.getTime() - horaEntrada.getTime();
        long minutosEstacionado = (tempoEstacionado / 1000) / 60;

        double valor = minutosEstacionado * valorPorMinuto;
        return Math.max(valor, valorMinimo);

    }
}
