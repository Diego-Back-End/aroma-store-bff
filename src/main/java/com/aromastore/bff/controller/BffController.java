package com.aromastore.bff.controller;

import com.aromastore.bff.client.PedidoClient;
import com.aromastore.bff.client.ProductoClient;
import com.aromastore.bff.client.UsuarioClient;
import com.aromastore.bff.dto.DashboardResponse;
import com.aromastore.bff.dto.PedidoDetalleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bff")
public class BffController {

    @Autowired
    private ProductoClient productoClient;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private PedidoClient pedidoClient;

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardResponse> getDashboard() {
        List<Object> productos = new ArrayList<>();
        List<Object> usuarios = new ArrayList<>();
        List<Object> pedidos = new ArrayList<>();

        // Obtener productos con manejo individual de errores
        try {
            productos = productoClient.getAllProductos();
        } catch (Exception e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
            // productos permanece como lista vacía
        }

        // Obtener usuarios con manejo individual de errores
        try {
            usuarios = usuarioClient.getAllUsuarios();
        } catch (Exception e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
            // usuarios permanece como lista vacía
        }

        // Obtener pedidos con manejo individual de errores
        try {
            pedidos = pedidoClient.getAllPedidos();
        } catch (Exception e) {
            System.err.println("Error al obtener pedidos: " + e.getMessage());
            // pedidos permanece como lista vacía
        }

        DashboardResponse response = new DashboardResponse(productos, usuarios, pedidos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pedidos/{usuarioId}")
    public ResponseEntity<List<PedidoDetalleResponse>> getPedidosConDetalles(@PathVariable Long usuarioId) {
        try {
            List<Object> pedidos = pedidoClient.getPedidosByUsuarioId(usuarioId);
            List<PedidoDetalleResponse> pedidosConDetalles = new ArrayList<>();

            for (Object pedido : pedidos) {
                // Aquí necesitaríamos extraer el productoId del pedido
                // Por ahora, usaremos un producto de ejemplo
                Object producto = null;
                
                try {
                    // Intentar obtener el producto (necesitaríamos parsear el pedido para extraer productoId)
                    // Por ahora, dejamos producto como null
                    producto = null;
                } catch (Exception e) {
                    // Si no se puede obtener el producto, continuamos con null
                }

                pedidosConDetalles.add(new PedidoDetalleResponse(pedido, producto));
            }

            return ResponseEntity.ok(pedidosConDetalles);
        } catch (Exception e) {
            return ResponseEntity.ok(new ArrayList<>());
        }
    }
}
