package com.gabriel.manytomanyrelationwithextracolumns.example.api.controller;

import com.gabriel.manytomanyrelationwithextracolumns.example.api.assembler.JogoUsuarioAssembler;
import com.gabriel.manytomanyrelationwithextracolumns.example.api.assembler.PedidoAssembler;
import com.gabriel.manytomanyrelationwithextracolumns.example.api.assembler.UsuarioAssembler;
import com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.model.JogoUsuarioResumoModel;
import com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.model.PedidoResumoModel;
import com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.model.UsuarioModel;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Pedido;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Usuario;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.repository.UsuarioRepository;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioRepository repository;
    private final JogoUsuarioAssembler jogoUsuarioAssembler;
    private final PedidoAssembler pedidoAssembler;
    private final UsuarioAssembler assembler;

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/{usuarioId}")
    public UsuarioModel buscar(@PathVariable Long usuarioId) {
        return assembler.toModel(service.buscarPorId(usuarioId));
    }

    @GetMapping("/{usuarioId}/pedidos")
    public List<PedidoResumoModel> buscarPedidos(@PathVariable Long usuarioId) {
        var usuario = repository.findById(usuarioId);
        return usuario.map(u -> pedidoAssembler.toCollectionModel(u.getPedidos())).orElse(null);
    }

    @GetMapping("/{usuarioId}/jogos")
    public List<JogoUsuarioResumoModel> buscarJogos(@PathVariable Long usuarioId) {
        var usuario = repository.findById(usuarioId);
        return usuario.map(u -> jogoUsuarioAssembler.toCollectionModel(u.getJogos())).orElse(null);

    }


}
