package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.OrdemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdemPedidoRepository extends JpaRepository<OrdemPedido, Long> {
    List<OrdemPedido> findOrdemPedidoByStatus(int status);
}
