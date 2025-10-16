package org.acme.domain.model.enuns;

public enum PagamentoStatus {

    PENDENTE("PENDENTE"), CONFIRMADO("CONFIRMADO"), FALHOU("FALHOU");

    private String tipo;

    PagamentoStatus(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
