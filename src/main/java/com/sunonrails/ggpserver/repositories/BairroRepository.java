package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BairroRepository extends JpaRepository<Bairro, Long> {

    Bairro findByNome(String nome);

    Boolean existsBairroByNome(String nome);
}
