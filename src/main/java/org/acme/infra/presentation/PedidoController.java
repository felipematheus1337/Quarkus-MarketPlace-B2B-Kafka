package org.acme.infra.presentation;


import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.acme.application.usecase.CriarPedidoUserCase;
import org.acme.domain.model.Pedido;
import org.acme.infra.mapper.PedidoMapper;
import org.acme.infra.presentation.request.PedidoRequest;

@Path("/v1/pedido")
public class PedidoController {

    @Inject
    CriarPedidoUserCase criarPedidoUserCase;

    public Response criarPedido(PedidoRequest request) {
        Pedido pedido = PedidoMapper.requestToEntity(request);
        criarPedidoUserCase.executar(pedido);
        return Response.ok().build();
    }
}
