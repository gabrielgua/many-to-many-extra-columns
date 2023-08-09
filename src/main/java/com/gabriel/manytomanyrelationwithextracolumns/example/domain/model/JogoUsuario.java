package com.gabriel.manytomanyrelationwithextracolumns.example.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class JogoUsuario {

    public JogoUsuario(Jogo jogo, Usuario usuario) {
        setJogo(jogo);
        setUsuario(usuario);
    }

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Jogo jogo;

    @ManyToOne
    private Usuario usuario;

    @CreationTimestamp
    private OffsetDateTime dataCriacao;

    private String chave = UUID.randomUUID().toString();


}
