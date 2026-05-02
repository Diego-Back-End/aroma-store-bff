package com.aromastore.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "usuario-client", url = "http://localhost:8082/api/usuarios")
public interface UsuarioClient {

    @GetMapping
    List<Object> getAllUsuarios();

    @GetMapping("/{id}")
    Object getUsuarioById(@PathVariable("id") Long id);

}
