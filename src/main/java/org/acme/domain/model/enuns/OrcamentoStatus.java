package org.acme.domain.model.enuns;

public enum OrcamentoStatus {

    GERADO("GERADO"), ACEITO("ACEITO"), EXPIRADO("EXPIRADO");

    private String tipo;

    OrcamentoStatus(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
