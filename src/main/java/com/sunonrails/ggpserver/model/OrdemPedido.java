package com.sunonrails.ggpserver.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrdemPedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private long operador_id;
    private long entregador_id;

    private String forma_pagamento, data_entrada, horario_entrada,
            horario_triagem, horario_checkout, horario_finalizado;

    private String fonte_pedido;
    private String status;
    private double troco;
    private String caixa_responsavel;
    private long status_id;

    @ManyToMany
    @JoinTable(name = "pedido_produto",
               joinColumns = @JoinColumn(name = "produto_id"),
               inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private List<Produto> produtos = new ArrayList<>();

    public OrdemPedido() {
    }

    public OrdemPedido(long id, String forma_pagamento, String data_entrada,
                       String horario_entrada, String horario_triagem,
                       String horario_checkout, String horario_finalizado,
                       long operador_id, long entregador_id, String fonte_pedido,
                       String status, double troco, String caixa_responsavel,
                       long status_id) {
        this.id = id;
        this.forma_pagamento = forma_pagamento;
        this.data_entrada = data_entrada;
        this.horario_entrada = horario_entrada;
        this.horario_triagem = horario_triagem;
        this.horario_checkout = horario_checkout;
        this.horario_finalizado = horario_finalizado;
        this.operador_id = operador_id;
        this.entregador_id = entregador_id;
        this.fonte_pedido = fonte_pedido;
        this.status = status;
        this.troco = troco;
        this.caixa_responsavel = caixa_responsavel;
        this.status_id = status_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getOperador_id() {
        return operador_id;
    }

    public void setOperador_id(long operador_id) {
        this.operador_id = operador_id;
    }

    public long getEntregador_id() {
        return entregador_id;
    }

    public void setEntregador_id(long entregador_id) {
        this.entregador_id = entregador_id;
    }

    public String getFonte_pedido() {
        return fonte_pedido;
    }

    public void setFonte_pedido(String fonte_pedido) {
        this.fonte_pedido = fonte_pedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public String getCaixa_responsavel() {
        return caixa_responsavel;
    }

    public void setCaixa_responsavel(String caixa_responsavel) {
        this.caixa_responsavel = caixa_responsavel;
    }

    public long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(long status_id) {
        this.status_id = status_id;
    }
}
