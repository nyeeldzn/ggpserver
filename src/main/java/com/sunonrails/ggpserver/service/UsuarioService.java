package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.Account;
import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.Usuario;
import com.sunonrails.ggpserver.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario find(Long id){
        Optional<Usuario> obj = repo.findById(id);
        obj.get().setPass(null);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Usuario de id: " + id + " nao encontrado!"
        ));
    }

    public Usuario findByUsername(String username){
        return repo.findByUsername(username);
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
        obj.setPass(passwordEncoder.encode(obj.getPass()));
        accountService.save(new Account(obj.getUsername(),obj.getPass(),obj.getPriv()));
        return repo.save(obj);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
