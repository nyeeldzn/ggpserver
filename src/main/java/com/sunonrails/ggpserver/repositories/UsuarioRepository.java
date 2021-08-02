package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
