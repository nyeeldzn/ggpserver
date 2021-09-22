package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.OrdemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrdemPedidoRepository extends JpaRepository<OrdemPedido, Long> {
    List<OrdemPedido> findOrdemPedidoByStatus(int status);

    List<OrdemPedido> findByEntradaDateGreaterThanAndEntradaDateLessThan(Date dInicial, Date dFinal);

    //@Query(value = "SELECT '*' FROM OrdemPedido where 'ENTRADA_DATE' BETWEEN :startDate AND  :endDate")
    @Query(
            value = "SELECT * FROM ORDEMPEDIDO WHERE ENTRADA_DATE BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<OrdemPedido> getAllBetweenDates(@Param("startDate")String startDate, @Param("endDate")String endDate);
}
