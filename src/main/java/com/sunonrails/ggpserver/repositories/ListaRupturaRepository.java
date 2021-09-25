package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.ListaRuptura;
import com.sunonrails.ggpserver.model.OrdemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListaRupturaRepository extends JpaRepository<ListaRuptura, Long> {

}
