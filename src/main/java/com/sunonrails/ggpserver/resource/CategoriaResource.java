package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Categoria;
import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> findAll(){
        return service.findAll();
    }

    @RequestMapping(name = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> find(@PathVariable Long id){
        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public Categoria insert(@RequestBody Categoria obj){
        return service.insert(obj);
    }

}
