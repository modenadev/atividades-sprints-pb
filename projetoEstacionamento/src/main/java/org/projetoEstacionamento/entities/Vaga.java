package org.projetoEstacionamento.entities;

public class Vaga {
    private int numero;
    private int id;

    public Vaga(int id, int numero) {
        this.id = id;
        this.numero = numero;
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
}
