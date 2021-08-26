package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNome (String nome);

}
