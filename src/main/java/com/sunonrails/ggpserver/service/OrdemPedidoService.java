package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.OrdemPedido;
import com.sunonrails.ggpserver.model.OrderProduct;
import com.sunonrails.ggpserver.repositories.OrdemPedidoRepository;
import com.sunonrails.ggpserver.repositories.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemPedidoService {

    @Autowired
    private OrdemPedidoRepository repo;

    @Autowired
    private OrderProductService orderService;


    public OrdemPedido find(Long id){
        Optional<OrdemPedido> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Pedido com id: " + id + " nao foi encontrado"
        ));
    }

    public List<OrdemPedido> findAll(){
        return repo.findAll();
    }

    public List<OrdemPedido> findAllByStatus(int status){
        return repo.findOrdemPedidoByStatus(status);
    }

    public OrdemPedido insert(OrdemPedido pedido){

        return repo.save(pedido);
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public OrdemPedido updateList(OrdemPedido ped){
        OrdemPedido newObj = find(ped.getId());
        updateData(newObj, ped);
        return repo.save(newObj);
    }

    private void updateData(OrdemPedido newObj, OrdemPedido obj){
        newObj.setCliente(obj.getCliente());
        newObj.setOperador(obj.getOperador());
        newObj.setEntregador(obj.getEntregador());
        newObj.setForma_pagamento(obj.getForma_pagamento());
        newObj.setEntradaDate(obj.getEntradaDate());
        newObj.setEntradaHora(obj.getEntradaHora());
        newObj.setTriagemHora(obj.getTriagemHora());
        newObj.setCheckoutHora(obj.getCheckoutHora());
        newObj.setFinalizadoHora(obj.getFinalizadoHora());
        newObj.setFonte_pedido(obj.getFonte_pedido());
        newObj.setCaixa_responsavel(obj.getCaixa_responsavel());
        newObj.setStatus(obj.getStatus());
        List<OrderProduct> newOrderList = orderService.insertList(obj.getOrderProducts());
        newObj.setOrderProducts(newOrderList);
    }
}
