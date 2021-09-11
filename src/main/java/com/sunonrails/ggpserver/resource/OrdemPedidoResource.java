package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.dto.OrdemPedidoDTO;
import com.sunonrails.ggpserver.model.OrdemPedido;
import com.sunonrails.ggpserver.repositories.OrdemPedidoRepository;
import com.sunonrails.ggpserver.service.OrdemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class OrdemPedidoResource {

    @Autowired
    private OrdemPedidoService service;

    @GetMapping
    public List<OrdemPedido> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OrdemPedido find(@PathVariable Long id){
        return service.find(id);
    }

    @PostMapping
    public OrdemPedido insert(@RequestBody OrdemPedidoDTO pedidoDTO){
        OrdemPedido pedido = new OrdemPedido(pedidoDTO.getId(), pedidoDTO.getCliente(), pedidoDTO.getOperador(),
                pedidoDTO.getEntregador(), pedidoDTO.getForma_pagamento(), pedidoDTO.getFonte_pedido(),
                pedidoDTO.getCaixa_responsavel(), pedidoDTO.getStatus());
        pedido.setEntradaDate(pedido.toDate(pedidoDTO.getEntradaDate()));
        pedido.setEntradaHora(pedido.toTime(pedidoDTO.getEntradaHora()));
        pedido.setTriagemHora(pedido.toTime(pedidoDTO.getTriagemHora()));
        pedido.setCheckoutHora(pedido.toTime(pedidoDTO.getCheckoutHora()));
        pedido.setFinalizadoHora(pedido.toTime(pedidoDTO.getFinalizadoHora()));
        return service.insert(pedido);
    }

    @PutMapping
    public OrdemPedido updateProdutos(@RequestBody OrdemPedido ped){
        return service.updateList(ped);
    }

}
