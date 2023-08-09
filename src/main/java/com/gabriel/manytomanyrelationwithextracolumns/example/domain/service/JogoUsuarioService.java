package com.gabriel.manytomanyrelationwithextracolumns.example.domain.service;

import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Jogo;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.JogoUsuario;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Pedido;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.repository.JogoUsuarioRepository;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JogoUsuarioService {

    private final JogoUsuarioRepository repository;
    private final UsuarioService usuarioService;

    public void salvar(Pedido pedido) {
        var usuario = pedido.getUsuario();
        var jogosUsuario = pedido.getJogos().stream().map(j -> {
            var jogoUsuario = new JogoUsuario(j, usuario);
            jogoUsuario.setChave(gerarChaveAtivacao());
            jogoUsuario.setDataCriacao(OffsetDateTime.now());
            return repository.save(jogoUsuario);
        }).collect(Collectors.toSet());

        usuario.getJogos().addAll(jogosUsuario);
    }

    private String gerarChaveAtivacao() {
        return UUID.randomUUID().toString();
    }
}
