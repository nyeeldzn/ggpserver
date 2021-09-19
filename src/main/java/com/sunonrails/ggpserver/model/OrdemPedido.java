package com.sunonrails.ggpserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    private String forma_pagamento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date entradaDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date entradaHora;

    @Temporal(TemporalType.TIMESTAMP)
    private Date triagemHora;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkoutHora;

    @Temporal(TemporalType.TIMESTAMP)
    private Date enviadoHora;

    @Temporal(TemporalType.TIMESTAMP)
    private Date finalizadoHora;

    private String fonte_pedido;
    private String caixa_responsavel;

    private int status;
    //1 -- pendende
    //2 -- triagem
    //3 -- chekout
    //4 -- enviado
    //5 -- finalizado


    /*
    @ManyToMany
    @JoinTable(name = "pedido_produto",
               joinColumns = @JoinColumn(name = "produto_id"),
               inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private List<Produto> produtos = new ArrayList<>();

     */
    @JsonManagedReference
    @OneToMany(mappedBy = "pedido")
    @Valid
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public OrdemPedido() {
    }

    public OrdemPedido(Long id, Cliente cliente, Usuario operador, String entregador, String forma_pagamento,
                       String fonte_pedido, String caixa_responsavel, int status) {
        this.id = id;
        this.cliente = cliente;
        this.operador = operador;
        this.entregador = entregador;
        this.forma_pagamento = forma_pagamento;
        this.fonte_pedido = fonte_pedido;
        this.caixa_responsavel = caixa_responsavel;
        this.status = status;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }

    public Date toDate(String sDate){
        Date date = null;
        try {
            SimpleDateFormat fDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            date = fDate.parse(sDate);
        }catch (ParseException pe){
            pe.printStackTrace();
        }
        return date;
    }

    public Date toTime(String sTime){
        Date time = null;
        try {
            SimpleDateFormat fTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            time = fTime.parse(sTime);
        }catch (ParseException pe){
            pe.printStackTrace();
        }
        return time;
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

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getCaixa_responsavel() {
        return caixa_responsavel;
    }

    public void setCaixa_responsavel(String caixa_responsavel) {
        this.caixa_responsavel = caixa_responsavel;
    }

    public Date getEntradaDate() {
        return entradaDate;
    }

    public void setEntradaDate(Date entradaDate) {
        this.entradaDate = entradaDate;
    }

    public Date getEntradaHora() {
        return entradaHora;
    }

    public void setEntradaHora(Date entradaHora) {
        this.entradaHora = entradaHora;
    }

    public Date getTriagemHora() {
        return triagemHora;
    }

    public void setTriagemHora(Date triagemHora) {
        this.triagemHora = triagemHora;
    }

    public Date getCheckoutHora() {
        return checkoutHora;
    }

    public void setCheckoutHora(Date checkoutHora) {
        this.checkoutHora = checkoutHora;
    }

    public Date getEnviadoHora() {
        return enviadoHora;
    }

    public void setEnviadoHora(Date enviadoHora) {
        this.enviadoHora = enviadoHora;
    }

    public Date getFinalizadoHora() {
        return finalizadoHora;
    }

    public void setFinalizadoHora(Date finalizadoHora) {
        this.finalizadoHora = finalizadoHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemPedido that = (OrdemPedido) o;
        return status == that.status && Objects.equals(id, that.id) && Objects.equals(cliente, that.cliente) && Objects.equals(operador, that.operador) && Objects.equals(entregador, that.entregador) && Objects.equals(forma_pagamento, that.forma_pagamento) && Objects.equals(entradaDate, that.entradaDate) && Objects.equals(entradaHora, that.entradaHora) && Objects.equals(triagemHora, that.triagemHora) && Objects.equals(checkoutHora, that.checkoutHora) && Objects.equals(finalizadoHora, that.finalizadoHora) && Objects.equals(fonte_pedido, that.fonte_pedido) && Objects.equals(caixa_responsavel, that.caixa_responsavel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, operador, entregador, forma_pagamento, entradaDate, entradaHora, triagemHora, checkoutHora, finalizadoHora, fonte_pedido, caixa_responsavel, status);
    }
}
