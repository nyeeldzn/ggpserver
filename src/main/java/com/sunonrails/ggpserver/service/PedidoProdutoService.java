package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.DataIntegrityException;
import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.PedidoProduto;
import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.repositories.PedidoProdutoRepository;
import com.sunonrails.ggpserver.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoProdutoService {

    @Autowired
    PedidoProdutoRepository repo;

    public PedidoProduto findById(Long id){
        Optional<PedidoProduto> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Objeto nao encontrado! Id: " + id + " Categoria: " + PedidoProduto.class.getName()
        ));
    }

    public List<PedidoProduto> findAll(){
        return repo.findAll();
    }

    public PedidoProduto insert(PedidoProduto produto){
        produto.setId(null);
        return repo.save(produto);
    }

    public PedidoProduto update(PedidoProduto produto){
        PedidoProduto newObj = findById(produto.getId());
        updateData(newObj, produto);
        return repo.save(newObj);
    }

    public void deleteById (Long id) {
        findById(id);
        try{
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Nao e possivel excluir um produto que esta em pedidos");
        }
    }

    private void updateData(PedidoProduto newObj, PedidoProduto obj){
        newObj.setNome(obj.getNome());
    }


}
