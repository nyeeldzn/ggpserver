package com.sunonrails.ggpserver.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class OrdemPedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "operador_id")
    private Usuario operador;

    private String entregador;

    private String forma_pagamento, data_entrada, horario_entrada,
            horario_triagem, horario_checkout, horario_finalizado;

    private String fonte_pedido;
    private String caixa_responsavel;

    private int status;
    //1 -- pendende
    //2 -- triagem
    //3 -- chekout
    //4 -- enviado
    //5 -- finalizado


    @ManyToMany
    @JoinTable(name = "pedido_produto",
               joinColumns = @JoinColumn(name = "produto_id"),
               inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private List<Produto> produtos = new ArrayList<>();

    public OrdemPedido() {
    }

    public OrdemPedido(Long id, Cliente cliente, Usuario operador,String entregador, String forma_pagamento,
                       String data_entrada, String horario_entrada, String horario_triagem, String horario_checkout,
                       String horario_finalizado, String fonte_pedido, String caixa_responsavel, int status,
                       List<Produto> produtos) {
        this.id = id;
        this.cliente = cliente;
        this.operador = operador;
        this.entregador = entregador;
        this.forma_pagamento = forma_pagamento;
        this.data_entrada = data_entrada;
        this.horario_entrada = horario_entrada;
        this.horario_triagem = horario_triagem;
        this.horario_checkout = horario_checkout;
        this.horario_finalizado = horario_finalizado;
        this.fonte_pedido = fonte_pedido;
        this.caixa_responsavel = caixa_responsavel;
        this.status = status;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getHorario_entrada() {
        return horario_entrada;
    }

    public void setHorario_entrada(String horario_entrada) {
        this.horario_entrada = horario_entrada;
    }

    public String getHorario_triagem() {
        return horario_triagem;
    }

    public void setHorario_triagem(String horario_triagem) {
        this.horario_triagem = horario_triagem;
    }

    public String getHorario_checkout() {
        return horario_checkout;
    }

    public void setHorario_checkout(String horario_checkout) {
        this.horario_checkout = horario_checkout;
    }

    public String getHorario_finalizado() {
        return horario_finalizado;
    }

    public void setHorario_finalizado(String horario_finalizado) {
        this.horario_finalizado = horario_finalizado;
    }

    public Usuario getOperador() {
        return operador;
    }

    public void setOperador(Usuario operador) {
        this.operador = operador;
    }

    public String getEntregador() {
        return entregador;
    }

    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }

    public String getFonte_pedido() {
        return fonte_pedido;
    }

    public void setFonte_pedido(String fonte_pedido) {
        this.fonte_pedido = fonte_pedido;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getCaixa_responsavel() {
        return caixa_responsavel;
    }

    public void setCaixa_responsavel(String caixa_responsavel) {
        this.caixa_responsavel = caixa_responsavel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemPedido that = (OrdemPedido) o;
        return status == that.status && Objects.equals(id, that.id) && Objects.equals(cliente, that.cliente) && Objects.equals(operador, that.operador) && Objects.equals(entregador, that.entregador) && Objects.equals(forma_pagamento, that.forma_pagamento) && Objects.equals(data_entrada, that.data_entrada) && Objects.equals(horario_entrada, that.horario_entrada) && Objects.equals(horario_triagem, that.horario_triagem) && Objects.equals(horario_checkout, that.horario_checkout) && Objects.equals(horario_finalizado, that.horario_finalizado) && Objects.equals(fonte_pedido, that.fonte_pedido) && Objects.equals(caixa_responsavel, that.caixa_responsavel) && Objects.equals(produtos, that.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, operador, entregador, forma_pagamento, data_entrada, horario_entrada, horario_triagem, horario_checkout, horario_finalizado, fonte_pedido, caixa_responsavel, status, produtos);
    }
}
