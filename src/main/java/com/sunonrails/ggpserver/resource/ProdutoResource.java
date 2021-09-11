package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> find(@PathVariable Long id){
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/buscaPorNome", method = RequestMethod.POST)
    public List<Produto> findClientesByNome(@RequestBody Produto produto){
        return service.findAllByName(produto.getNome());
    }

    @GetMapping
    public List<Produto> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Produto insert(@RequestBody Produto produto){
        return service.insert(produto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
       service.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Produto produto){
        service.update(produto);
    }

}
