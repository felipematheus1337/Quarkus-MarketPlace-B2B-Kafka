package org.acme.domain.services;

import org.acme.domain.exceptions.DomainExceptions;
import org.acme.domain.model.Pagamento;
import org.acme.domain.model.enuns.PagamentoStatus;

public class PagamentoDomainService {

    public void confirmar(Pagamento pagamento) {
        if (pagamento.getStatus() != PagamentoStatus.PENDENTE) {
            throw new DomainExceptions("Pagamento já processado.");
        }
        pagamento.atualizarStatus(PagamentoStatus.CONFIRMADO);
    }

    public void marcarComoFalhou(Pagamento pagamento) {
        pagamento.atualizarStatus(PagamentoStatus.FALHOU);
    }
}
