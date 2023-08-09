package com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PedidoRequest {

    private UsuarioIdRequest usuario;
    private Set<JogoIdRequest> jogos;
}
