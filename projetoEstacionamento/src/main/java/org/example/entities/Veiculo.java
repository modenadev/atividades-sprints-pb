package org.example.entities;

public class Veiculo {

    private String placa;
    private String TipoVeiculo;


    public Veiculo(String placa, String tipoVeiculo) {
        this.placa = placa;
        TipoVeiculo = tipoVeiculo;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVeiculo() {
        return TipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        TipoVeiculo = tipoVeiculo;
    }



}
