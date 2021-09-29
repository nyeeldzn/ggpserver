package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.ListaRuptura;
import com.sunonrails.ggpserver.model.ListaRuptura;
import com.sunonrails.ggpserver.model.OrderProduct;
import com.sunonrails.ggpserver.model.RupturaProduto;
import com.sunonrails.ggpserver.repositories.ListaRupturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ListaRupturaService {

    @Autowired
    private ListaRupturaRepository repo;

    @Autowired
    private RupturaProdutoService rupturaService;


    public ListaRuptura find(Long id){
        Optional<ListaRuptura> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Pedido com id: " + id + " nao foi encontrado"
        ));
    }

    public List<ListaRuptura> findAll(){
        return repo.findAll();
    }

    public List<ListaRuptura> findAllByDates(String iDate, String fDate) {
        return repo.getAllBetweenDates(iDate, fDate);
    }

    public ListaRuptura insert(ListaRuptura pedido){
        return repo.save(pedido);
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public ListaRuptura updateList(ListaRuptura ped){
        ListaRuptura newObj = find(ped.getId());
        System.out.println("Retorno da Busca: \n" + newObj);
        updateData(newObj, ped);
        System.out.println("Retorno do updateData: \n" + newObj);

        ListaRuptura pedidoSalvo = repo.save(newObj);
        System.out.println("Retorno do pedido Salvo: \n" + pedidoSalvo);
        //return repo.save(newObj);
        return pedidoSalvo;
    }

    private void updateData(ListaRuptura newObj, ListaRuptura obj){
        newObj.setDesc(obj.getDesc());
        List<RupturaProduto> newProdutoLista = rupturaService.insertList(obj.getProdutoList());
        newObj.setProdutoList(newProdutoLista);
        newObj.setDate(obj.getDate());
    }


}
