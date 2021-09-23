package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.OrdemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrdemPedidoRepository extends JpaRepository<OrdemPedido, Long> {
    List<OrdemPedido> findOrdemPedidoByStatus(int status);

    @Query(
            value = "SELECT * FROM ORDEMPEDIDO WHERE ENTRADA_DATE BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<OrdemPedido> getAllBetweenDates(@Param("startDate")String startDate, @Param("endDate")String endDate);

    @Query(
            value = "SELECT * FROM ORDEMPEDIDO WHERE STATUS = :status AND ENTRADA_DATE BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<OrdemPedido> getAllBetweenDatesWithStatus(@Param("startDate")String startDate, @Param("endDate")String endDate, @Param("status")int status);

}
