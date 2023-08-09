package com.gabriel.manytomanyrelationwithextracolumns.example.api.assembler;

import com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.model.JogoUsuarioResumoModel;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.JogoUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class JogoUsuarioAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public JogoUsuarioResumoModel toModel(JogoUsuario jogoUsuario) {
        return modelMapper.map(jogoUsuario, JogoUsuarioResumoModel.class);
    }

    public List<JogoUsuarioResumoModel> toCollectionModel(Set<JogoUsuario> jogosUsuario) {
        return jogosUsuario.stream()
                .map(this::toModel)
                .toList();
    }
}
