package org.acme.infra.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    private String id;
    private BigDecimal valorTotal;
    private String status;

    public PedidoEntity() {
    }

    public PedidoEntity(String id, BigDecimal valorTotal, String status) {
        this.id = id;
        this.valorTotal = valorTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
