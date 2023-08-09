package com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.model;

import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Jogo;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class JogoUsuarioResumoModel {

    private Long id;
    private Jogo jogo;
    private Long usuarioId;
    private OffsetDateTime dataCriacao;
    private String chave;
}
