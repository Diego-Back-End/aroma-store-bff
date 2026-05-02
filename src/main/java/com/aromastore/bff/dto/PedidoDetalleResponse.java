package com.aromastore.bff.dto;

import lombok.Data;

@Data
public class PedidoDetalleResponse {
    
    private Object pedido;
    private Object producto;
    
    public PedidoDetalleResponse() {}
    
    public PedidoDetalleResponse(Object pedido, Object producto) {
        this.pedido = pedido;
        this.producto = producto;
    }
    
}
