package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public List<Cliente> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public Cliente findById(@PathVariable Long id){
        return service.find(id);
    }

    @RequestMapping(value = "/buscaPorNome", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public List<Cliente> findClientesByNome(@RequestBody Cliente cliente){
        return service.findAllByName(cliente.getNome());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public Cliente insert(@RequestBody Cliente cliente) {
            return service.insert(cliente);
    }


    @RequestMapping(value = "/inserirLista", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public List<Cliente> insertList(@RequestBody List<Cliente> cliente) {
        return service.insertList(cliente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('admin')")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public void update(@RequestBody Cliente cliente){
        service.update(cliente);
    }

}
