package com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UsuarioModel {

    private Long id;
    private String email;
    private Set<PedidoResumoModel> pedidos;
    private Set<JogoUsuarioResumoModel> jogos;
}
