package com.sunonrails.ggpserver.controllers;

import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController()
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;



    @GetMapping()
    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    @PostMapping()
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
