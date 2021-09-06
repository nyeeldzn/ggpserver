package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public Cliente findByNome(String nome){
        Cliente cli = repo.findByNome(nome);
        if(cli.getId() != null && !(cli.getNome().equals(""))){
            return cli;
        }else{
            throw new ObjectNotFoundException("Cliente de nome: " + nome + " nao encontrado!");
        }
    }

    public List<Cliente> findAllByName(String nome) {
        List<Cliente> clientes = repo.findClienteByNome(nome);
        return clientes;
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

    @Transactional
    public Cliente insert (Cliente obj) {
        return repo.save(obj);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Cliente update(Cliente cli){
        Cliente newObj = find(cli.getId());
        updateData(newObj, cli);
        return repo.save(newObj);
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setBairro(obj.getBairro());
        newObj.setEndereco(obj.getEndereco());
        newObj.setTelefone(obj.getTelefone());
    }


}
