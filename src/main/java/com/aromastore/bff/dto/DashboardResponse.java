package com.aromastore.bff.dto;

import lombok.Data;

import java.util.List;

@Data
public class DashboardResponse {
    
    private List<Object> productos;
    private List<Object> usuarios;
    private List<Object> pedidos;
    
    public DashboardResponse() {}
    
    public DashboardResponse(List<Object> productos, List<Object> usuarios, List<Object> pedidos) {
        this.productos = productos;
        this.usuarios = usuarios;
        this.pedidos = pedidos;
    }
    
}
