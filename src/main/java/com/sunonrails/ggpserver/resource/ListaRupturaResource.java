package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.ListaRuptura;
import com.sunonrails.ggpserver.model.PedidoFindJsonHelper;
import com.sunonrails.ggpserver.service.ListaRupturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listaRuptura")
public class ListaRupturaResource {

    @Autowired
    private ListaRupturaService service;

    @GetMapping
    public List<ListaRuptura> findAll(){
        return service.findAll();
    }

    //EndPoint Pedidos
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ListaRuptura find(@PathVariable Long id){
        return service.find(id);
    }


    @PostMapping
    public ListaRuptura insert(@RequestBody ListaRuptura pedido){
        return service.insert(pedido);
    }

    @PutMapping
    public ListaRuptura updateProdutos(@RequestBody ListaRuptura ped){
        System.out.println("Println Pedido \n" + ped);
        return service.updateList(ped);
    }

}
