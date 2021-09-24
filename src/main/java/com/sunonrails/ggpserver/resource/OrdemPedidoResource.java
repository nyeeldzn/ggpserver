package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.dto.OrdemPedidoDTO;
import com.sunonrails.ggpserver.model.PedidoFindJsonHelper;
import com.sunonrails.ggpserver.model.OrdemPedido;
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

    //EndPoint Pedidos
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OrdemPedido find(@PathVariable Long id){
        return service.find(id);
    }

    @RequestMapping(value = "/buscaPorStatus/{status}", method = RequestMethod.GET)
    public List<OrdemPedido> findByStatus(@PathVariable Integer status){
        return service.findAllByStatus(status);
    }

    @RequestMapping(value = "/buscaPorData", method = RequestMethod.POST)
    public List<OrdemPedido> findByData(@RequestBody PedidoFindJsonHelper pedidoFindJsonHelper){
        return service.findAllByDate(pedidoFindJsonHelper.getDataInicial(), pedidoFindJsonHelper.getDataFinal());
    }

    @RequestMapping(value = "/buscaPorDataComStatus/{status}", method = RequestMethod.POST)
    public List<OrdemPedido> findByDataComStatus(@RequestBody PedidoFindJsonHelper pedidoFindJsonHelper, @PathVariable Integer status){
        return service.findAllByDateAndStatus(pedidoFindJsonHelper.getDataInicial(), pedidoFindJsonHelper.getDataFinal(), status);
    }

    //EndPoint Filtro Pedidos-Cliente
    @RequestMapping(value = "/buscaPorDataPorCliente", method = RequestMethod.POST)
    public List<OrdemPedido> findByDataFromClient(@RequestBody PedidoFindJsonHelper pedidoFindJsonHelper){
        return service.findAllByDateFromClient(pedidoFindJsonHelper.getDataInicial(), pedidoFindJsonHelper.getDataFinal(), pedidoFindJsonHelper.getCliente().getId());
    }

    @RequestMapping(value = "/buscaPorDataComStatusPorCliente/{status}", method = RequestMethod.POST)
    public List<OrdemPedido> findByDataComStatusFromClient(@RequestBody PedidoFindJsonHelper pedidoFindJsonHelper, @PathVariable Integer status){
        return service.findAllByDateAndStatusFromClient(pedidoFindJsonHelper.getDataInicial(), pedidoFindJsonHelper.getDataFinal(), status, pedidoFindJsonHelper.getCliente().getId());
    }

    @PostMapping
    public OrdemPedido insert(@RequestBody OrdemPedidoDTO pedidoDTO){
        OrdemPedido pedido = new OrdemPedido(pedidoDTO.getId(), pedidoDTO.getCliente(), pedidoDTO.getOperador(),
                pedidoDTO.getEntregador(), pedidoDTO.getForma_pagamento(), pedidoDTO.getFonte_pedido(),
                pedidoDTO.getCaixa_responsavel(), pedidoDTO.getStatus());
        pedido.setEntradaDate(pedidoDTO.getEntradaDate());
        pedido.setEntradaHora(pedido.toTime(pedidoDTO.getEntradaHora()));
        pedido.setTriagemHora(pedido.toTime(pedidoDTO.getTriagemHora()));
        pedido.setCheckoutHora(pedido.toTime(pedidoDTO.getCheckoutHora()));
        pedido.setFinalizadoHora(pedido.toTime(pedidoDTO.getFinalizadoHora()));
        return service.insert(pedido);
    }

    @PutMapping
    public OrdemPedido updateProdutos(@RequestBody OrdemPedido ped){
        System.out.println("Println Pedido \n" + ped);
        return service.updateList(ped);
    }

}
