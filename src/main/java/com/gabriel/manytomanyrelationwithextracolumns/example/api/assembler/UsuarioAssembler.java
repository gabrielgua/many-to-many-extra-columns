package com.gabriel.manytomanyrelationwithextracolumns.example.api.assembler;

import com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.model.UsuarioModel;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioModel toModel(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioModel.class);
    }
}
