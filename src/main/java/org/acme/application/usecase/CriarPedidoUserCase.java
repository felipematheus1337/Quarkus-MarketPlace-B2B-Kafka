package org.acme.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.application.gateways.PedidoGateway;
import org.acme.domain.exceptions.DomainExceptions;
import org.acme.domain.model.Pedido;

import java.math.BigDecimal;


public class CriarPedidoUserCase {

    private final PedidoGateway pedidoGateway;

    public CriarPedidoUserCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public void executar(Pedido pedido) {
        validarPedido(pedido);
        this.pedidoGateway.criarPedido(pedido);
    }

    private void validarPedido(Pedido pedido) {
        if (pedido.getValorTotal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new DomainExceptions("Pedido deve ter um valor maior que zero.");
        }
    }
}
