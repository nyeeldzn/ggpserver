package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Bairro;
import com.sunonrails.ggpserver.model.OrderProduct;
import com.sunonrails.ggpserver.service.BairroService;
import com.sunonrails.ggpserver.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/orderproduct")
public class OrderProductResource {

    @Autowired
    private OrderProductService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OrderProduct findById(@PathVariable Long id){
        return service.find(id);
    }

    @PostMapping
    public OrderProduct insert(@RequestBody OrderProduct orderProduct) {
            return service.insert(orderProduct);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }



}
