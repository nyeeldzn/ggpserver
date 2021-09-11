package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.exceptions.DataIntegrityException;
import com.sunonrails.ggpserver.exceptions.ObjectNotFoundException;
import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repo;

    public Produto findById(Long id){
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Objeto nao encontrado! Id: " + id + " Categoria: " + Produto.class.getName()
        ));
    }

    public List<Produto> findAllByName(String nome) {
        List<Produto> produtos = repo.findProdutoByNome(nome);
        return produtos;
    }

    public List<Produto> findAll(){
        return repo.findAll();
    }

    public Produto insert(Produto produto){
        produto.setId(null);
        return repo.save(produto);
    }

    public Produto update(Produto produto){
        Produto newObj = findById(produto.getId());
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

    private void updateData(Produto newObj, Produto obj){
        newObj.setNome(obj.getNome());
    }


}
