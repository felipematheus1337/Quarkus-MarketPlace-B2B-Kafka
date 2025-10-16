package org.acme.infra.mapper;

import org.acme.domain.event.PedidoEvent;
import org.acme.domain.model.Pedido;
import org.acme.infra.persistence.entities.PedidoEntity;

public class PedidoMapper {

    public static PedidoEntity toEntity(Pedido pedido) {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(pedido.getId().toString());
        entity.setValorTotal(pedido.getValorTotal());
        return entity;
    }

    public static PedidoEvent toEvent(Pedido pedido) {
        PedidoEvent event = new PedidoEvent();
        event.setPedidoId(pedido.getId().toString());
        event.setValor(pedido.getValorTotal());
        return event;
    }
}
