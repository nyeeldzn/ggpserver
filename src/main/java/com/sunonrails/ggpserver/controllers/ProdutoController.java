package com.sunonrails.ggpserver.controllers;

import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> find(@PathVariable Long id){
        Produto obj = produtoRepository.getById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping
    public void delete(@RequestBody Long id){
         produtoRepository.deleteById(id);
    }
}
