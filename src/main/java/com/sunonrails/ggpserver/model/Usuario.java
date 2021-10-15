package com.sunonrails.ggpserver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String pass;
    private String priv;

    @OneToMany(mappedBy = "operador")
    private List<OrdemPedido> pedidos = new ArrayList<>();

    public Usuario () {}

    public Usuario(Long id, String username, String pass, String priv) {
        this.id = id;
        this.username = username.toUpperCase().trim();
        this.pass = pass;
        this.priv = priv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toUpperCase().trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPriv() {
        return priv;
    }

    public void setPriv(String priv) {
        this.priv = priv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return priv == usuario.priv && Objects.equals(id, usuario.id) && Objects.equals(username, usuario.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, priv);
    }
}
