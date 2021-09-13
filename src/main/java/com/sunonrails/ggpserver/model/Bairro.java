package com.sunonrails.ggpserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nome;

    @OneToMany(mappedBy = "bairro", cascade = CascadeType.ALL)
    private List<Cliente> clientes;

    public Bairro () {}

    public Bairro(Long id, @NonNull String nome) {
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
        Bairro bairro = (Bairro) o;
        return Objects.equals(id, bairro.id) && nome.equals(bairro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
