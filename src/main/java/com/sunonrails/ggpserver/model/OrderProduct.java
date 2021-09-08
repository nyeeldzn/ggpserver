package com.sunonrails.ggpserver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedidos_id")
    private OrdemPedido pedido;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public OrdemPedido getPedido() {
        return pedido;
    }

    @Column(nullable = false)
    private Integer quantity;

    public OrderProduct(){}

    public OrderProduct(OrdemPedido pedido, Produto produto, Integer quantity) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public void setPedido(OrdemPedido pedido) {
        this.pedido = pedido;
    }

    @Transient
    public Produto getProduto() {
        return produto;
    }

    @Transient
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Transient
    public Integer getQuantity() {
        return quantity;
    }

    @Transient
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProduct that = (OrderProduct) o;
        return Objects.equals(id, that.id) && Objects.equals(pedido, that.pedido) && Objects.equals(produto, that.produto) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pedido, produto, quantity);
    }
}
