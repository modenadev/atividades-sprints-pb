package org.projetoEstacionamento.entities;

public class Veiculo {
    private String placa;
    private String tipo;
    private boolean mensalista;

    public Veiculo() {
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
