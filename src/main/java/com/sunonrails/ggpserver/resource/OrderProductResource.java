package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Bairro;
import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.OrderProduct;
import com.sunonrails.ggpserver.service.BairroService;
import com.sunonrails.ggpserver.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/orderproduct")
public class OrderProductResource {

    @Autowired
    private OrderProductService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('visitante','user','admin')")
    public OrderProduct findById(@PathVariable Long id){
        return service.find(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('user','admin')")
    public OrderProduct insert(@RequestBody OrderProduct orderProduct) {
            return service.insert(orderProduct);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('user','admin')")
    public void delete(@RequestBody OrderProduct orderProduct){
        service.deleteById(orderProduct.getId());
    }



}
