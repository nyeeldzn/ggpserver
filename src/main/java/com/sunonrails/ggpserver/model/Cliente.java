package com.sunonrails.ggpserver.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String nome;

    @NonNull
    private String endereco;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "bairro_id")
    private Bairro bairro;

    @NonNull
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<OrdemPedido> pedidos = new ArrayList<>();

    public Cliente(){}

    public Cliente(Long id, @NonNull String nome, @NonNull String endereco, @NonNull Bairro bairro, @NonNull String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.telefone = telefone;
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

    @NonNull
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NonNull String endereco) {
        this.endereco = endereco;
    }

    @NonNull
    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(@NonNull Bairro bairro) {
        this.bairro = bairro;
    }

    @NonNull
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NonNull String telefone) {
        this.telefone = telefone;
    }
}
