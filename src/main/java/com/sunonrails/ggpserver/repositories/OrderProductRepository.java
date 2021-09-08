package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
