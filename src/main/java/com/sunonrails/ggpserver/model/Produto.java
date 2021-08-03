package com.sunonrails.ggpserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "produtos")
    private List<OrdemPedido> pedidos = new ArrayList<>();

    @JsonIgnore
    @ManyToMany()
    @JoinTable(name = "PRODUTO_CATEGORIA",
                joinColumns = @JoinColumn(name = "produto_id"),
                inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias = new ArrayList<>();

    public Produto() {
    }

    public Produto(Long id, @NonNull String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && nome.equals(produto.nome) && Objects.equals(pedidos, produto.pedidos) && Objects.equals(categorias, produto.categorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, pedidos, categorias);
    }
}
