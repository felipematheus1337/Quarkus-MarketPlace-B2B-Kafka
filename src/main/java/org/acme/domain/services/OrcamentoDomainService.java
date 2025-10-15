package org.acme.domain.services;

import org.acme.domain.exceptions.DomainExceptions;
import org.acme.domain.model.Orcamento;
import org.acme.domain.model.enuns.OrcamentoStatus;

public class OrcamentoDomainService {

    public void aceitar(Orcamento orcamento) {
        if (orcamento.getStatus() != OrcamentoStatus.GERADO) {
            throw new DomainExceptions("Orçamento já foi aceito ou expirado.");
        }
        orcamento.atualizarStatus(OrcamentoStatus.ACEITO);
    }

    public void expirar(Orcamento orcamento) {
        if (orcamento.getStatus() == OrcamentoStatus.ACEITO) {
            throw new DomainExceptions("Orçamento aceito não pode expirar.");
        }
        orcamento.atualizarStatus(OrcamentoStatus.EXPIRADO);
    }
}
