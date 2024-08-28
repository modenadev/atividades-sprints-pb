package org.projetoEstacionamento.entities;

public class Vaga {
    private int numero;
    private int id;
    private String tipo;
    private String status;


    public Vaga(int numero, int id, String tipo, String status) {
        this.numero = numero;
        this.id = id;
        this.tipo = tipo;
        this.status = status;
    }

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
        return tipo;
    }

    public void setCategoria(String tipo) {
        this.tipo = tipo;
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
