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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List<OrdemPedido> findAllByDate(String dInicial, String dFinal){
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1;
        String ds1 = "";
        String ds2 = "";
        Date d2;
        try{
            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(dInicial);
            ds1  = new SimpleDateFormat("yyyy-MM-dd").format(d1);
            System.out.println(ds1);
            d2 = new SimpleDateFormat("yyyy-MM-dd").parse(dFinal);
            ds2 = new SimpleDateFormat("yyyy-MM-dd").format(d2);
            System.out.println(ds2);
        }catch (ParseException pe){
            pe.printStackTrace();
        }
        //return repo.findByEntradaDateGreaterThanAndEntradaDateLessThan(d1, d2);
        return repo.getAllBetweenDates(ds1,ds2);
    }

    public List<OrdemPedido> findAllByDateAndStatus(String dInicial, String dFinal,Integer status){
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1;
        String ds1 = "";
        String ds2 = "";
        Date d2;
        try{
            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(dInicial);
            ds1  = new SimpleDateFormat("yyyy-MM-dd").format(d1);
            System.out.println(ds1);
            d2 = new SimpleDateFormat("yyyy-MM-dd").parse(dFinal);
            ds2 = new SimpleDateFormat("yyyy-MM-dd").format(d2);
            System.out.println(ds2);
        }catch (ParseException pe){
            pe.printStackTrace();
        }
        //return repo.findByEntradaDateGreaterThanAndEntradaDateLessThan(d1, d2);
        return repo.getAllBetweenDatesWithStatus(ds1,ds2,status);
    }


    //Filtro Cliente
    public List<OrdemPedido> findAllByDateFromClient(String dInicial, String dFinal, Long clienteId){
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1;
        String ds1 = "";
        String ds2 = "";
        Date d2;
        try{
            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(dInicial);
            ds1  = new SimpleDateFormat("yyyy-MM-dd").format(d1);
            System.out.println(ds1);
            d2 = new SimpleDateFormat("yyyy-MM-dd").parse(dFinal);
            ds2 = new SimpleDateFormat("yyyy-MM-dd").format(d2);
            System.out.println(ds2);
        }catch (ParseException pe){
            pe.printStackTrace();
        }
        return repo.getAllBetweenDatesFromClient(ds1,ds2, clienteId);
    }

    public List<OrdemPedido> findAllByDateAndStatusFromClient(String dInicial, String dFinal,Integer status, Long clienteId){
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1;
        String ds1 = "";
        String ds2 = "";
        Date d2;
        try{
            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(dInicial);
            ds1  = new SimpleDateFormat("yyyy-MM-dd").format(d1);
            System.out.println(ds1);
            d2 = new SimpleDateFormat("yyyy-MM-dd").parse(dFinal);
            ds2 = new SimpleDateFormat("yyyy-MM-dd").format(d2);
            System.out.println(ds2);
        }catch (ParseException pe){
            pe.printStackTrace();
        }
        return repo.getAllBetweenDatesWithStatusFromClient(ds1,ds2,status, clienteId);
    }


    public OrdemPedido insert(OrdemPedido pedido){
        return repo.save(pedido);
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public OrdemPedido updateList(OrdemPedido ped){
        OrdemPedido newObj = find(ped.getId());
        System.out.println("Retorno da Busca: \n" + newObj);
        updateData(newObj, ped);
        System.out.println("Retorno do updateData: \n" + newObj);

        OrdemPedido pedidoSalvo = repo.save(newObj);
        System.out.println("Retorno do pedido Salvo: \n" + pedidoSalvo);
        //return repo.save(newObj);
        return pedidoSalvo;
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
