package com.sunonrails.ggpserver.service;

import ch.qos.logback.core.net.server.Client;
import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Long id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Cliente de id: " + id + " nao encontrado!"
        ));
    }

    public List<Cliente> findAll(){
        return repo.findAll();
    }

    public List<Cliente> insertList(List<Cliente> list){
        List<Cliente> clientSaveCheck = new ArrayList<>();
        for(int i = 0; i<list.size(); i++){
            clientSaveCheck.add(repo.save(list.get(i)));
        }
        return clientSaveCheck;
    }

    public Cliente insert (Cliente obj) {
        return repo.save(obj);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
