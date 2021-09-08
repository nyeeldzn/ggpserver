package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.OrdemPedido;
import com.sunonrails.ggpserver.repositories.OrdemPedidoRepository;
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

    public OrdemPedido find(Long id){
        Optional<OrdemPedido> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Pedido com id: " + id + " nao foi encontrado"
        ));
    }

    public List<OrdemPedido> findAll(){
        return repo.findAll();
    }

    public OrdemPedido insert(OrdemPedido pedido){

        return repo.save(pedido);
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

}
