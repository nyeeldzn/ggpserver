package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.Categoria;
import com.sunonrails.ggpserver.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Long id){
        Optional<Categoria> newObj = repo.findById(id);
        return newObj.orElseThrow( () -> new ObjectNotFoundException(
                "Categoria nao encontrada"
        ));
    }

    public List<Categoria> findAll(){
        return repo.findAll();
    }

    public Categoria insert(Categoria categoria){
            return repo.save(categoria);
    }

    public Categoria update(Categoria categoria){
        Categoria newObj = find(categoria.getId());
        updateData(newObj, categoria);
        return repo.save(newObj);
    }


    public Categoria updateData(Categoria newObj, Categoria obj){
        newObj.setNome(obj.getNome());
        return newObj;
    }

}
