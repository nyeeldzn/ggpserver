package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Bairro;
import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.service.BairroService;
import com.sunonrails.ggpserver.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bairros")
public class BairroResource {

    @Autowired
    private BairroService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public List<Bairro> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public Bairro findById(@PathVariable Long id){
        return service.find(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('Operador', 'Admin')")
    public Bairro insert(@RequestBody Bairro bairro) {
            return service.insert(bairro);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('Admin')")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('Operador','Admin')")
    public void update(@RequestBody Bairro bairro){
        service.update(bairro);
    }

}
