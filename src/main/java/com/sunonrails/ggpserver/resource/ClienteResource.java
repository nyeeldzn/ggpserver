package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cliente findById(@PathVariable Long id){
        return service.find(id);
    }

    /*
    @RequestMapping(value = "/buscaPorNome/{nome}", method = RequestMethod.GET)
    public Cliente findById(@PathVariable String nome){
        return service.findByNome(nome.toUpperCase());
    }

     */

    @RequestMapping(value = "/buscaPorNome", method = RequestMethod.POST)
    public List<Cliente> findClientesByNome(@RequestBody Cliente cliente){
        return service.findAllByName(cliente.getNome());
    }

    @PostMapping
    public Cliente insert(@RequestBody Cliente cliente) {
            return service.insert(cliente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Cliente cliente){
        service.update(cliente);
    }

}
