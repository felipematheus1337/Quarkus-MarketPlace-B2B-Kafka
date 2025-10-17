package org.acme.infra.mapper;

import org.acme.domain.event.OrcamentoEvent;
import org.acme.domain.model.Orcamento;
import org.acme.domain.model.enuns.OrcamentoStatus;
import org.acme.infra.persistence.entities.OrcamentoEntity;

import java.util.UUID;

public class OrcamentoMapper {

    public static OrcamentoEntity toEntity(Orcamento orcamento) {
        OrcamentoEntity entity = new OrcamentoEntity();
        entity.setId(orcamento.getId().toString());
        entity.setPedidoId(orcamento.getPedidoId().toString());
        entity.setValor(orcamento.getValor());
        entity.setStatus(orcamento.getStatus().toString());
        entity.setDataGeracao(orcamento.getDataGeracao());
        return entity;
    }


    public static Orcamento toDomain(OrcamentoEntity entity) {
        Orcamento orcamento = new Orcamento(
                UUID.fromString(entity.getPedidoId()),
                UUID.fromString(entity.getId()),
                entity.getValor()
        );
        orcamento.atualizarStatus(OrcamentoStatus.valueOf(entity.getStatus()));
        return orcamento;
    }

    public static OrcamentoEvent toEvent(Orcamento orcamento) {
        OrcamentoEvent event = new OrcamentoEvent();
        event.setId(orcamento.getId());
        event.setPedidoId(orcamento.getPedidoId());
        event.setValor(orcamento.getValor());
        event.setStatus(orcamento.getStatus().toString());
        event.setDataGeracao(orcamento.getDataGeracao());
        return event;
    }
}
