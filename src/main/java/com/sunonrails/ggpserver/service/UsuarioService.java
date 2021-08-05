package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.Usuario;
import com.sunonrails.ggpserver.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario find(Long id){
        Optional<Usuario> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Usuario de id: " + id + " nao encontrado!"
        ));
    }

    public List<Usuario> findAll(){
        return repo.findAll();
    }

    public List<Usuario> insertList(List<Usuario> list){
        List<Usuario> clientSaveCheck = new ArrayList<>();
        for(int i = 0; i<list.size(); i++){
            clientSaveCheck.add(repo.save(list.get(i)));
        }
        return clientSaveCheck;
    }

    @Transactional
    public Usuario insert (Usuario obj) {
        return repo.save(obj);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
