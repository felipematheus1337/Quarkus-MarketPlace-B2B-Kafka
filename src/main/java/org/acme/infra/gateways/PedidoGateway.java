package org.acme.infra.gateways;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.domain.event.PedidoEvent;
import org.acme.domain.model.Pedido;
import org.acme.domain.model.enuns.PedidoStatus;
import org.acme.infra.mapper.PedidoMapper;
import org.acme.infra.persistence.entities.PedidoEntity;
import org.acme.infra.persistence.repositories.PedidoEntityRepository;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class PedidoGateway implements org.acme.application.gateways.PedidoGateway {

    @Inject
    PedidoEntityRepository repository;

    @Inject
    @Channel("pedido-criado")
    Emitter<PedidoEvent> emitter;


    @Override
    public void criarPedido(Pedido pedido) {
        PedidoEntity entity = PedidoMapper.toEntity(pedido);
        repository.persist(entity);

        PedidoEvent event = PedidoMapper.toEvent(pedido);
        emitter.send(event);
    }

    @Transactional
    @Override
    public void atualizarStatus(Pedido pedido) {
        var pedidoParaAtualizar = repository.find("id", pedido.getId())
                .firstResult();

        if (pedidoParaAtualizar == null) {
            throw new RuntimeException("Pedido não encontrado.");
        }

        pedidoParaAtualizar.setStatus(pedido.getStatus().toString());
    }
}
