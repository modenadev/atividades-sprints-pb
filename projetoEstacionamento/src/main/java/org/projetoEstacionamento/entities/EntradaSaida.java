package org.projetoEstacionamento.entities;

import java.util.Date;

public class EntradaSaida {
    private int id;
    private String placa;
    private Date horaEntrada;
    private Date horaSaida;
    private int cancelaEntrada;
    private int cancelaSaida;
    private int vagaId;
    private double valorPago;

    public EntradaSaida() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }

    public int getCancelaEntrada() {
        return cancelaEntrada;
    }

    public void setCancelaEntrada(int cancelaEntrada) {
        this.cancelaEntrada = cancelaEntrada;
    }

    public int getCancelaSaida() {
        return cancelaSaida;
    }

    public void setCancelaSaida(int cancelaSaida) {
        this.cancelaSaida = cancelaSaida;
    }

    public int getVagaId() {
        return vagaId;
    }

    public void setVagaId(int vagaId) {
        this.vagaId = vagaId;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}

