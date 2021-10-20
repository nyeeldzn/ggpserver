package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('Visitante','Operador','Admin')")
    public ResponseEntity<Produto> find(@PathVariable Long id){
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/buscaPorNome", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('Operador','Admin')")
    public List<Produto> findClientesByNome(@RequestBody Produto produto){
        System.out.println(produto.getNome().toUpperCase());
        return service.findAllByName(produto.getNome().toUpperCase(Locale.ROOT));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('Visitante','Operador','Admin')")
    public List<Produto> findAll(){
        return service.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('Operador','Admin')")
    public Produto insert(@RequestBody Produto produto){
        return service.insert(produto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('Admin')")
    public void delete(@PathVariable Long id){
       service.deleteById(id);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('Operador','Admin')")
    public void update(@RequestBody Produto produto){
        service.update(produto);
    }

}
