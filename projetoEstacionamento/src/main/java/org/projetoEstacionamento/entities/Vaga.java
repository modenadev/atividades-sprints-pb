package org.projetoEstacionamento.entities;

public class Vaga {
    private int numero;
    private int id;
    private String tipo;
    private String categoria;
    private String status;


    public Vaga() {

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String isOcupada() {
        return "A vaga está ocupada";
    }
}
