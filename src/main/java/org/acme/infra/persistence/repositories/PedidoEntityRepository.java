package org.acme.infra.persistence.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.infra.persistence.entities.PedidoEntity;

public class PedidoEntityRepository implements PanacheRepository<PedidoEntity> {
}
