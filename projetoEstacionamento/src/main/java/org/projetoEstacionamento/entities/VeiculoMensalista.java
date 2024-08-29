package org.projetoEstacionamento.entities;

public class VeiculoMensalista {

    private String placaMensalista;
    private String tipo;
    private String categoria;
    private boolean mensalista;
    private int taxa_mensal;

    // Construtor padrão
    public VeiculoMensalista() {}

    // Getters e Setters
    public String getPlacaMensalista() {
        return placaMensalista;
    }

    public void setPlacaMensalista(String placa) {
        this.placaMensalista = placa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isMensalista() {
        return mensalista;
    }

    public void setMensalista(boolean mensalista) {
        this.mensalista = mensalista;
    }

    public int getTaxa_mensal() {
        return taxa_mensal;
    }

    public void setTaxa_mensal(int taxa_mensal) {
        this.taxa_mensal = taxa_mensal;
    }
}
