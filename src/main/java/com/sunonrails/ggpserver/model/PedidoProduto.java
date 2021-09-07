package com.sunonrails.ggpserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class PedidoProduto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "produtos")
    private List<OrdemPedido> pedidos = new ArrayList<>();

    public PedidoProduto(Long id, @NonNull String nome) {
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

    public List<OrdemPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<OrdemPedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoProduto that = (PedidoProduto) o;
        return Objects.equals(id, that.id) && nome.equals(that.nome) && Objects.equals(pedidos, that.pedidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, pedidos);
    }
}
