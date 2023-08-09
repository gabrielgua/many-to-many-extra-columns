package com.gabriel.manytomanyrelationwithextracolumns.example.api.controller;

import com.gabriel.manytomanyrelationwithextracolumns.example.api.assembler.PedidoAssembler;
import com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.model.PedidoResumoModel;
import com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.request.PedidoRequest;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Pedido;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidoService service;
    private final PedidoAssembler assembler;

    @PostMapping
    public PedidoResumoModel salvar(@RequestBody PedidoRequest request) {
        var pedido = assembler.toEntity(request);
        return assembler.toModel(service.salvar(pedido));
    }
}
