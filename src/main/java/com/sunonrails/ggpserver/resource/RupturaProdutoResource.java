package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.RupturaProduto;
import com.sunonrails.ggpserver.model.PedidoFindJsonHelper;
import com.sunonrails.ggpserver.service.RupturaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listaRuptura/rupturaProdutos")
public class RupturaProdutoResource {

    @Autowired
    private RupturaProdutoService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('user','admin')")
    public List<RupturaProduto> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('user','admin')")
    public RupturaProduto find(@PathVariable Long id){
        return service.find(id);
    }



    @PostMapping
    @PreAuthorize("hasAnyRole('user','admin')")
    public RupturaProduto insert(@RequestBody RupturaProduto pedido){
        return service.insert(pedido);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('user','admin')")
    public RupturaProduto updateProdutos(@RequestBody RupturaProduto ped){
        System.out.println("Println Produto \n" + ped);
        return service.updateList(ped);
    }

}
