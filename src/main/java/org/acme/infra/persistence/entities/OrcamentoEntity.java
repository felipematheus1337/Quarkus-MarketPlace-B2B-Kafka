package org.acme.infra.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orcamento")
public class OrcamentoEntity {

    @Id
    private String id;
    private String pedidoId;
    private BigDecimal valor;
    private String status;
    private LocalDateTime dataGeracao;

    public OrcamentoEntity() {
    }

    public OrcamentoEntity(String id, String pedidoId, BigDecimal valor, String status, LocalDateTime dataGeracao) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.valor = valor;
        this.status = status;
        this.dataGeracao = dataGeracao;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPedidoId() { return pedidoId; }
    public void setPedidoId(String pedidoId) { this.pedidoId = pedidoId; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataGeracao() { return dataGeracao; }
    public void setDataGeracao(LocalDateTime dataGeracao) { this.dataGeracao = dataGeracao; }
}
