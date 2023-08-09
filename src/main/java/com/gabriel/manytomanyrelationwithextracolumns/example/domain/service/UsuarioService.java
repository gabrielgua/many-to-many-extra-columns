package com.gabriel.manytomanyrelationwithextracolumns.example.domain.service;

import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Usuario;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long usuarioId) {
        return repository.findById(usuarioId).orElseThrow();
    }

}
