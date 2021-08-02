package com.sunonrails.ggpserver.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String nome;

    @NonNull
    private String endereco;

    @NonNull
    private String bairro;

    @NonNull
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<OrdemPedido> pedidos = new ArrayList<>();

    public Cliente(){}

    public Cliente(@NonNull String nome, @NonNull String endereco, @NonNull String bairro, @NonNull String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.telefone = telefone;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    public String getBairro() {
        return bairro;
    }

    public void setBairro(@NonNull String bairro) {
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
