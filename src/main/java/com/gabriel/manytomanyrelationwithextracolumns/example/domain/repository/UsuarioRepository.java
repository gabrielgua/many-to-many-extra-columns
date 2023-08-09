package com.gabriel.manytomanyrelationwithextracolumns.example.domain.repository;

import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
