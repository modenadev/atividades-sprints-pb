package org.projetoEstacionamento.entities;

import java.sql.Timestamp;

public class Ticket {

    private String cancelaEntrada;
    private String cancelaSaida;
    private Timestamp horaEntrada;
    private Timestamp horaSaida;
    private int vaga;
    private double totalValor;


    public Ticket(String cancelaEntrada, String cancelaSaida, String horaEntrada, String horaSaida, Integer vaga, Integer totalValor) {
        this.cancelaEntrada = cancelaEntrada;
        this.cancelaSaida = cancelaSaida;
        this.horaEntrada = Timestamp.valueOf(horaEntrada);
        this.horaSaida = Timestamp.valueOf(horaSaida);
        this.vaga = vaga;
        this.totalValor = totalValor;
    }

    public String getCancelaEntrada() {
        return cancelaEntrada;
    }

    public void setCancelaEntrada(String cancelaEntrada) {
        this.cancelaEntrada = cancelaEntrada;
    }

    public String getCancelaSaida() {
        return cancelaSaida;
    }

    public void setCancelaSaida(String cancelaSaida) {
        this.cancelaSaida = cancelaSaida;
    }

    public Timestamp getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = Timestamp.valueOf(horaEntrada);
    }

    public Timestamp getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = Timestamp.valueOf(horaSaida);
    }

    public Integer getVaga() {
        return vaga;
    }

    public void setVaga(Integer vaga) {
        this.vaga = vaga;
    }

    public Integer getTotalValor() {
        return (int) totalValor;
    }

    public void setTotalValor(Integer totalValor) {
        this.totalValor = totalValor;
    }
}
