package com.gabriel.manytomanyrelationwithextracolumns.example.domain.service;

import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Pedido;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final JogoUsuarioService jogoUsuarioService;
    private final UsuarioService usuarioService;

    @Transactional
    public Pedido salvar(Pedido pedido) {
        var usuario = usuarioService.buscarPorId(pedido.getUsuario().getId());
        pedido.setUsuario(usuario);

        jogoUsuarioService.salvar(pedido);
        return repository.save(pedido);
    }


}
