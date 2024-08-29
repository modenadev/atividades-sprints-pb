package org.projetoEstacionamento.entities;

public class VeiculoComum {
    private String placa;
    private String tipo;
    private String categoria;
    private boolean mensalista;

    // Construtor padrão
    public VeiculoComum() {}

    // Getters e Setters


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

    public boolean isMensalista() {
        return false;
    }

    public void setMensalista(boolean mensalista) {
        this.mensalista = mensalista;
    }
}
