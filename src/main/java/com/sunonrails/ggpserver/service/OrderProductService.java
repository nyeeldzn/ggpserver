package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.Bairro;
import com.sunonrails.ggpserver.model.OrdemPedido;
import com.sunonrails.ggpserver.model.OrderProduct;
import com.sunonrails.ggpserver.repositories.BairroRepository;
import com.sunonrails.ggpserver.repositories.OrderProductRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository repo;

    public OrderProduct find(Long id){
        Optional<OrderProduct> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Bairro de id: " + id + " nao encontrado!"
        ));
    }

    public List<OrderProduct> findAll(){
        return repo.findAll();
    }

    public List<OrderProduct> insertList (List<OrderProduct> list) {
        return repo.saveAll(list);
    }

    public OrderProduct insert (OrderProduct obj) {
        return repo.save(obj);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }


}
