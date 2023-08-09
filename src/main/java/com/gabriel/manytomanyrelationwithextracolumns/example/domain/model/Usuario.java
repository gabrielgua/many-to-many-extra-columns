package com.gabriel.manytomanyrelationwithextracolumns.example.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @OneToMany(mappedBy = "usuario")
    private Set<JogoUsuario> jogos = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Pedido> pedidos;
}
