package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.repositories.ProdutoRepository;
import com.sunonrails.ggpserver.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> find(@PathVariable Long id){
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @PostMapping
    public Produto insert(@RequestBody Produto produto){
        return produtoService.insert(produto);
    }

}
