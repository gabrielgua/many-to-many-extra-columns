package com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.model;

import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Jogo;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PedidoResumoModel {

    private Long id;

    private Set<Jogo> jogos;
}
