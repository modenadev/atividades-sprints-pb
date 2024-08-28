package org.example.entities;

public class Ticket {

    private String cancelaEntrada;
    private String cancelaSaida;
    private String horaEntrada;
    private String horaSaida;
    private Integer vaga;
    private Integer totalValor;


    public Ticket(String cancelaEntrada, String cancelaSaida, String horaEntrada, String horaSaida, Integer vaga, Integer totalValor) {
        this.cancelaEntrada = cancelaEntrada;
        this.cancelaSaida = cancelaSaida;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
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

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Integer getVaga() {
        return vaga;
    }

    public void setVaga(Integer vaga) {
        this.vaga = vaga;
    }

    public Integer getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(Integer totalValor) {
        this.totalValor = totalValor;
    }
}
