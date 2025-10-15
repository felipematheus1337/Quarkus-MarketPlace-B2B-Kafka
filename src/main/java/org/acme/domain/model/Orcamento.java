package org.acme.domain.model;

import org.acme.domain.model.enuns.OrcamentoStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Orcamento {

    private UUID id;
    private UUID pedidoId;
    private BigDecimal valor;
    private OrcamentoStatus status;
    private LocalDateTime dataGeracao;

    public void atualizarStatus(OrcamentoStatus status) {
        this.status = status;
    }

    public Orcamento(UUID pedidoId, UUID id, BigDecimal valor) {
        this.pedidoId = pedidoId;
        this.id = id;
        this.valor = valor;
        this.status = OrcamentoStatus.GERADO;
        this.dataGeracao = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public UUID getPedidoId() {
        return pedidoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public OrcamentoStatus getStatus() {
        return status;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }
}
