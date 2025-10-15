package org.acme.domain.model;

import org.acme.domain.model.enuns.PagamentoStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Pagamento {

    private UUID id;
    private UUID pedidoId;
    private BigDecimal valor;
    private PagamentoStatus status; // PENDENTE, CONFIRMADO, FALHOU
    private LocalDateTime dataCriacao;

    public void atualizarStatus(PagamentoStatus status) {
        this.status = status;
    }

    public Pagamento(UUID id, BigDecimal valor, UUID pedidoId) {
        this.id = id;
        this.valor = valor;
        this.pedidoId = pedidoId;
        this.status = PagamentoStatus.PENDENTE;
        this.dataCriacao = LocalDateTime.now();
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

    public PagamentoStatus getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
