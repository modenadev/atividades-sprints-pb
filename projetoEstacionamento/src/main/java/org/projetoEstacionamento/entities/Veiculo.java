package org.projetoEstacionamento.entities;

public class Veiculo  {

    private int id;
    private String placa;
    private String tipo;
    private String categoria;


    public Veiculo(String placa, String tipo, String categoria) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public Veiculo() {

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
