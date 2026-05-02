package com.aromastore.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "pedido-client", url = "http://localhost:8083/api/pedidos")
public interface PedidoClient {

    @GetMapping
    List<Object> getAllPedidos();

    @GetMapping("/{id}")
    Object getPedidoById(@PathVariable("id") Long id);

    @GetMapping("/usuario/{usuarioId}")
    List<Object> getPedidosByUsuarioId(@PathVariable("usuarioId") Long usuarioId);

}
