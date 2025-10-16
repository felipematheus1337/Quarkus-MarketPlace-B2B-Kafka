package org.acme.infra.messaging;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.application.usecase.GerarOrcamentoUseCase;
import org.acme.domain.event.PedidoEvent;
import org.acme.infra.mapper.PedidoMapper;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaPedidoConsumer {

    @Inject
    GerarOrcamentoUseCase gerarOrcamentoUseCase;

    @Incoming("pedido-criado")
    public void consumirPedido(PedidoEvent event) {
        var pedido = PedidoMapper.eventToDomain(event);

        gerarOrcamentoUseCase.executar(pedido);
    }
}
