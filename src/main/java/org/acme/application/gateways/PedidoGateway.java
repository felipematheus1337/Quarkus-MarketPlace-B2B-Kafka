package org.acme.application.gateways;

import org.acme.domain.model.Pedido;

public interface PedidoGateway {

    void criarPedido(Pedido pedido);
}
