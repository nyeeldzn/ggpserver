package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
