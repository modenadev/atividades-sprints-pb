package org.projetoEstacionamento.controller;

import org.projetoEstacionamento.enums.vehicleEnum;

public class VagaController {

    private int maximoVagasMensalistasDisponiveis = 200;
    private int maximoVagasComunsDisponiveis = 500 - maximoVagasMensalistasDisponiveis;
    private int vagasComumEmUso = 0;
    private int vagasMensalistasEmUso = 0 ;

    public String controleDeVagas(String tipoVeiculo, Boolean mensalista, Boolean entrando) {
        try {
            if(mensalista) {

               return controleMensalista(tipoVeiculo, entrando);
            }
            else {

               return controleVagaComum(tipoVeiculo, entrando);

            }

        } catch (IllegalArgumentException e) {
            return "Erro ao realizar o controle de vagas";
        }
    }

    public String controleMensalista(String tipoVeiculo, Boolean entrando) {
        try{
            int quantidadeVagasVeiculo = vehicleEnum.getQuantidadeDeVagasPorVeiculo(tipoVeiculo);
            int vagasDisponiveis = maximoVagasMensalistasDisponiveis - vagasMensalistasEmUso;

            if(entrando && vagasDisponiveis >= quantidadeVagasVeiculo) {
                vagasMensalistasEmUso = vagasMensalistasEmUso + quantidadeVagasVeiculo;
                return tipoVeiculo + " entrou no estacionamento. Agora " + vagasMensalistasEmUso + " vagas de mensagelistas em uso";
            }

            if(!entrando) {
                vagasMensalistasEmUso = vagasMensalistasEmUso - quantidadeVagasVeiculo;
                return tipoVeiculo + " deixou o estacionamento. Agora " + vagasMensalistasEmUso + " vagas de mensalistas em uso";
            }

            throw new IllegalArgumentException("Erro ao realizar o controle de vagas");
        }
        catch (IllegalArgumentException e) {
           return e.getMessage();
        }

    }


    public String controleVagaComum(String tipoVeiculo, Boolean entrando){
        try{
            int quantidadeVagasVeiculo = vehicleEnum.getQuantidadeDeVagasPorVeiculo(tipoVeiculo);
            int vagasDisponiveis = maximoVagasComunsDisponiveis - vagasComumEmUso;

            if(entrando && vagasDisponiveis >= quantidadeVagasVeiculo) {
                vagasComumEmUso = vagasComumEmUso + quantidadeVagasVeiculo;
                return tipoVeiculo + " entrou no estacionamento. Agora " + vagasMensalistasEmUso + " vagas comuns em uso";
            }

            if(!entrando) {
                vagasComumEmUso = vagasComumEmUso - quantidadeVagasVeiculo;
                return tipoVeiculo + " deixou o estacionamento. Agora " + vagasMensalistasEmUso + " vagas comuns em uso";
            }

            throw new IllegalArgumentException("Erro ao realizar o controle de vagas");
        }
        catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }



}
