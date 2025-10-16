package org.acme.domain.event;

import java.math.BigDecimal;

public class PedidoEvent {

    private String pedidoId;
    private BigDecimal valor;

    public PedidoEvent() {
    }

    public PedidoEvent(String pedidoId, BigDecimal valor) {
        this.pedidoId = pedidoId;
        this.valor = valor;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
