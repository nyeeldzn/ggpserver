package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.model.OrdemPedido;

import java.util.List;

public interface OrdemPedidoService {

    List<OrdemPedido> getPedidos();

    OrdemPedido getPedidoById(Long id);

    OrdemPedido insert(OrdemPedido pedido);

    void updatePedido(Long id, OrdemPedido pedido);

    void deletePedido(Long pedidoId);

}
