package com.sunonrails.ggpserver.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Entity
public class ListaRuptura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String desc;

    @JsonManagedReference
    @OneToMany(mappedBy = "listaRuptura")
    @Valid
    private List<RupturaProduto> produtoList;

    public ListaRuptura (){}

    public ListaRuptura(Long id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<RupturaProduto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<RupturaProduto> produtoList) {
        this.produtoList = produtoList;
    }
}
