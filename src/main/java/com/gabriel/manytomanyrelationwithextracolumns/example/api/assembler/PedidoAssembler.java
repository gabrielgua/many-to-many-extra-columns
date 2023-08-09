package com.gabriel.manytomanyrelationwithextracolumns.example.api.assembler;

import com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.model.PedidoResumoModel;
import com.gabriel.manytomanyrelationwithextracolumns.example.api.domain.request.PedidoRequest;
import com.gabriel.manytomanyrelationwithextracolumns.example.domain.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class PedidoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PedidoResumoModel toModel(Pedido pedido) {
        return modelMapper.map(pedido, PedidoResumoModel.class);
    }

    public List<PedidoResumoModel> toCollectionModel(Set<Pedido> pedidos) {
        return pedidos.stream()
                .map(this::toModel)
                .toList();
    }

    public Pedido toEntity(PedidoRequest request) {
        return modelMapper.map(request, Pedido.class);
    }
}
