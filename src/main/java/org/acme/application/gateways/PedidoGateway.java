package org.acme.application.gateways;

import org.acme.domain.model.Pedido;
import org.acme.domain.model.enuns.PedidoStatus;

public interface PedidoGateway {

    void criarPedido(Pedido pedido);

    void atualizarStatus(Pedido pedido);
}
