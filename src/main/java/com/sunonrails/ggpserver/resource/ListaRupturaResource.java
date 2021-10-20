package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.ListaRuptura;
import com.sunonrails.ggpserver.model.PedidoFindJsonHelper;
import com.sunonrails.ggpserver.service.ListaRupturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listaRuptura")
public class ListaRupturaResource {

    @Autowired
    private ListaRupturaService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public List<ListaRuptura> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public ListaRuptura find(@PathVariable Long id){
        return service.find(id);
    }

    @RequestMapping(value = "/buscaPorData", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public List<ListaRuptura> findAllByDate (@RequestBody PedidoFindJsonHelper dBH){
        return service.findAllByDates(dBH.getDataInicial(), dBH.getDataFinal());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public ListaRuptura insert(@RequestBody ListaRuptura pedido){
        return service.insert(pedido);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public ListaRuptura updateListaRuptura(@RequestBody ListaRuptura ped){
        System.out.println("Println ListRuptura \n" + ped);
        return service.updateList(ped);
    }

}
