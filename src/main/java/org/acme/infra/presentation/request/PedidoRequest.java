package org.acme.infra.presentation.request;

import java.math.BigDecimal;
import java.util.UUID;

public record PedidoRequest(BigDecimal valorTotal) {
}
