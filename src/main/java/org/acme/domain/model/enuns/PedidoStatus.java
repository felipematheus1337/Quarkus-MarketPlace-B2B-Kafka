package org.acme.domain.model.enuns;

public enum PedidoStatus {

    NOVO("NOVO"), EM_ORCAMENTO("EM_ORCAMENTO"), APROVADO("APROVADO"), CANCELADO("CANCELADO");

    private String tipo;

    PedidoStatus(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
