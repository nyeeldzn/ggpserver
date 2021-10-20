package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Usuario;
import com.sunonrails.ggpserver.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginResource {

    @Autowired
    private UsuarioService userService;

    @PostMapping
    @PreAuthorize("hasAnyRole('Visitante', 'Operador', 'Admin')")
    public Usuario login(@RequestBody Usuario userLogin) {
        Usuario user;
        System.out.println("Usuario Logado: " + userLogin.getUsername());
        user = userService.findByUsername(userLogin.getUsername().toUpperCase());
        user.setPass("");
        return user;
    }

    private boolean isAuthenticated(Authentication authentication) {
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }

}
