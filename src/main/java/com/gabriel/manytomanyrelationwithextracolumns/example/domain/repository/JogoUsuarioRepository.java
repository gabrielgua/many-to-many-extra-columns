package com.gabriel.manytomanyrelationwithextracolumns.example.domain.repository;

import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.JogoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoUsuarioRepository extends JpaRepository<JogoUsuario, Long> {
}
