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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ListaRuptura find(@PathVariable Long id){
        return service.find(id);
    }

    @RequestMapping(value = "/buscaPorData", method = RequestMethod.POST)
    public List<ListaRuptura> findAllByDate (@RequestBody PedidoFindJsonHelper dBH){
        return service.findAllByDates(dBH.getDataInicial(), dBH.getDataFinal());
    }

    @PostMapping
    public ListaRuptura insert(@RequestBody ListaRuptura pedido){
        return service.insert(pedido);
    }

    @PutMapping
    public ListaRuptura updateListaRuptura(@RequestBody ListaRuptura ped){
        System.out.println("Println ListRuptura \n" + ped);
        return service.updateList(ped);
    }

}
