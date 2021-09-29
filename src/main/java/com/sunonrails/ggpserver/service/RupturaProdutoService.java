package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.OrdemPedido;
import com.sunonrails.ggpserver.model.OrderProduct;
import com.sunonrails.ggpserver.model.RupturaProduto;
import com.sunonrails.ggpserver.repositories.OrdemPedidoRepository;
import com.sunonrails.ggpserver.repositories.RupturaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RupturaProdutoService {

    @Autowired
    private RupturaProdutoRepository repo;

    public RupturaProduto find(Long id){
        Optional<RupturaProduto> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Pedido com id: " + id + " nao foi encontrado"
        ));
    }

    public List<RupturaProduto> findAll(){
        return repo.findAll();
    }

    public RupturaProduto insert(RupturaProduto pedido){
        return repo.save(pedido);
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public RupturaProduto updateList(RupturaProduto ped){
        RupturaProduto newObj = find(ped.getId());
        System.out.println("Retorno da Busca: \n" + newObj);
        updateData(newObj, ped);
        System.out.println("Retorno do updateData: \n" + newObj);

        RupturaProduto pedidoSalvo = repo.save(newObj);
        System.out.println("Retorno do pedido Salvo: \n" + pedidoSalvo);
        //return repo.save(newObj);
        return pedidoSalvo;
    }

    private void updateData(RupturaProduto newObj, RupturaProduto obj){
        newObj.setProduto(obj.getProduto());
        newObj.setListaRuptura(obj.getListaRuptura());
    }

    public List<RupturaProduto> insertList (List<RupturaProduto> list) {
        return repo.saveAll(list);
    }
}
