package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.Bairro;
import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.repositories.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {

    @Autowired
    private BairroRepository repo;

    public Bairro find(Long id){
        Optional<Bairro> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Bairro de id: " + id + " nao encontrado!"
        ));
    }

    public List<Bairro> findAll(){
        return repo.findAll();
    }

    public Bairro insert (Bairro obj) {
        return repo.save(obj);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Bairro update(Bairro bairro){
        Bairro newObj = find(bairro.getId());
        updateData(newObj, bairro);
        return repo.save(newObj);
    }

    private void updateData(Bairro newObj, Bairro obj){
        newObj.setNome(obj.getNome());
    }
}
