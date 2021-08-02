package com.sunonrails.ggpserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrdemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long cliente_id;
    private String cliente_nome, end_cliente, num_cliente, forma_envio,
            forma_pagamento, forma_subst, data_entrada, horario_entrada,
            horario_triagem, horario_checkout, horario_finalizado;
    private long operador_id;
    private long entregador_id;
    private String fonte_pedido;
    private String status;
    private double troco;
    private String caixa_responsavel;
    private long status_id;

    public OrdemPedido() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getEnd_cliente() {
        return end_cliente;
    }

    public void setEnd_cliente(String end_cliente) {
        this.end_cliente = end_cliente;
    }

    public String getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(String num_cliente) {
        this.num_cliente = num_cliente;
    }

    public String getForma_envio() {
        return forma_envio;
    }

    public void setForma_envio(String forma_envio) {
        this.forma_envio = forma_envio;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public String getForma_subst() {
        return forma_subst;
    }

    public void setForma_subst(String forma_subst) {
        this.forma_subst = forma_subst;
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
