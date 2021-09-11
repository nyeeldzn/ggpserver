package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findProdutoByNome(String nome);
}
