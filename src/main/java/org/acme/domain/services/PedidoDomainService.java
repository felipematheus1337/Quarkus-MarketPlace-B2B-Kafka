package org.acme.domain.services;

import org.acme.domain.exceptions.DomainExceptions;
import org.acme.domain.model.Pedido;
import org.acme.domain.model.enuns.PedidoStatus;

public class PedidoDomainService {

    public void marcarComoEmOrcamento(Pedido pedido) {
        if (pedido.getStatus() != PedidoStatus.NOVO) {
            throw new DomainExceptions("Só pedidos novos podem ir para orçamento.");
        }
        pedido.atualizarStatus(PedidoStatus.EM_ORCAMENTO);
    }

    public void aprovar(Pedido pedido) {
        if (pedido.getStatus() != PedidoStatus.EM_ORCAMENTO) {
            throw new DomainExceptions("Pedido só pode ser aprovado após o orçamento.");
        }
        pedido.atualizarStatus(PedidoStatus.APROVADO);
    }

    public void cancelar(Pedido pedido) {
        if (pedido.getStatus() == PedidoStatus.APROVADO) {
            throw new DomainExceptions("Pedido aprovado não pode ser cancelado.");
        }
        pedido.atualizarStatus(PedidoStatus.CANCELADO);
    }
}
