package org.acme.infra.mapper;

import org.acme.domain.event.PedidoEvent;
import org.acme.domain.model.Pedido;
import org.acme.domain.model.enuns.PedidoStatus;
import org.acme.infra.persistence.entities.PedidoEntity;
import org.acme.infra.presentation.request.PedidoRequest;

import java.util.UUID;

public class PedidoMapper {

    public static PedidoEntity toEntity(Pedido pedido) {
        return new PedidoEntity(pedido.getId().toString(), pedido.getValorTotal(), pedido.getStatus().toString());
    }

    public static PedidoEvent toEvent(Pedido pedido) {
        PedidoEvent event = new PedidoEvent();
        event.setPedidoId(pedido.getId().toString());
        event.setValor(pedido.getValorTotal());
        return event;
    }

    public static Pedido requestToEntity(PedidoRequest request) {
        return  new Pedido(UUID.randomUUID(), request.valorTotal());
    }

    public static Pedido eventToDomain(PedidoEvent event) {
        return new Pedido(UUID.fromString(event.getPedidoId()), event.getValor());

    }
}
