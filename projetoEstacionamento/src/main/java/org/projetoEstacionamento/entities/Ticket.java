package org.projetoEstacionamento.entities;

import java.sql.Timestamp;
import java.util.Date;

public class Ticket {

    private int id;
    private String placa;
    private String tipo;
    private Date horaEntrada;
    private Date horaSaida;
    private int cancelaEntrada;
    private int cancelaSaida;
    private int vagaOcupada;
    private double valor;


    public Ticket() {

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public int getCancelaSaida() {
        return cancelaSaida;
    }

    public void setCancelaSaida(int cancelaSaida) {
        this.cancelaSaida = cancelaSaida;
    }

    public int getCancelaEntrada() {
        return cancelaEntrada;
    }

    public void setCancelaEntrada(int cancelaEntrada) {
        this.cancelaEntrada = cancelaEntrada;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getVagaOcupada() {
        return vagaOcupada;
    }

    public void setVagaOcupada(int vagaOcupada) {
        this.vagaOcupada = vagaOcupada;
    }
}
