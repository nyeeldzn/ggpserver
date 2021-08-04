package com.sunonrails.ggpserver.resource;

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
    public OrdemPedido insert(@RequestBody OrdemPedido pedido){
        return service.insert(pedido);
    }

}
