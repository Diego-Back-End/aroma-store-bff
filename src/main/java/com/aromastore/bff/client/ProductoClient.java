package com.aromastore.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "producto-client", url = "http://localhost:8081/api/productos")
public interface ProductoClient {

    @GetMapping
    List<Object> getAllProductos();

    @GetMapping("/{id}")
    Object getProductoById(@PathVariable("id") Long id);

}
