package org.acme.application.usecase;

import org.acme.application.gateways.OrcamentoGateway;
import org.acme.application.gateways.PedidoGateway;
import org.acme.domain.model.Orcamento;
import org.acme.domain.model.Pedido;
import org.acme.domain.model.enuns.PedidoStatus;
import org.acme.domain.services.PedidoDomainService;

import java.math.BigDecimal;
import java.util.UUID;

public class GerarOrcamentoUseCase {

    PedidoDomainService pedidoDomainService;
    PedidoGateway pedidoGateway;
    OrcamentoGateway orcamentoGateway;

    public void executar(Pedido pedido) {

        pedidoDomainService.marcarComoEmOrcamento(pedido);
        pedidoGateway.atualizarStatus(pedido);

        BigDecimal novoValor = this.calcularValor(pedido);
        Orcamento orcamento = new Orcamento(pedido.getId(), UUID.randomUUID(), novoValor);

        orcamentoGateway.criarOrcamento(orcamento);
    }

    public BigDecimal calcularValor(Pedido pedido) {
        double randomValue = Math.random();
        Long value = Long.valueOf(String.valueOf(randomValue));
        return BigDecimal.valueOf(value).multiply(pedido.getValorTotal());
    }

}