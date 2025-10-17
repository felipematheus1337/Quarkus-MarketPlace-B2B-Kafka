package org.acme.infra.gateways;

import jakarta.inject.Inject;
import org.acme.application.gateways.OrcamentoGateway;
import org.acme.domain.event.OrcamentoEvent;
import org.acme.domain.model.Orcamento;
import org.acme.infra.mapper.OrcamentoMapper;
import org.acme.infra.persistence.entities.OrcamentoEntity;
import org.acme.infra.persistence.repositories.OrcamentoEntityRepository;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

public class OrcamentoGatewayImpl implements OrcamentoGateway {


    @Inject
    @Channel("orcamento-gerado")
    Emitter<OrcamentoEvent> emitter;

    @Inject
    OrcamentoEntityRepository repository;

    @Override
    public void criarOrcamento(Orcamento orcamento) {

        OrcamentoEntity entidade = OrcamentoMapper.toEntity(orcamento);
        repository.persist(entidade);

        OrcamentoEvent event =  OrcamentoMapper.toEvent(orcamento);
        emitter.send(event);

    }
}
