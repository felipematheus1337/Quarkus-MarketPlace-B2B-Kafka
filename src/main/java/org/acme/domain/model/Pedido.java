package org.acme.domain.model;

import org.acme.domain.model.enuns.PedidoStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Pedido {

    private UUID id;
    private BigDecimal valorTotal;
    private PedidoStatus status;
    private LocalDateTime dataCriacao;

    public Pedido(UUID id, BigDecimal valorTotal) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.status = PedidoStatus.NOVO;
        this.dataCriacao = LocalDateTime.now();
    }

    public void atualizarStatus(PedidoStatus status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
