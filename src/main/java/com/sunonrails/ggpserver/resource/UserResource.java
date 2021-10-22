package com.sunonrails.ggpserver.resource;

import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.Usuario;
import com.sunonrails.ggpserver.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserResource {

    /*
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        System.out.println("Fechando sessao com id: " + session.getId() );
        return "/clientes";
    }
     */

    @Autowired
    private UsuarioService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('Admin')")
    public List<Usuario> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('Admin')")
    public Usuario findById(@PathVariable Long id){
        return service.find(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('Admin')")
    public Usuario insert(@RequestBody Usuario Usuario) {
            return service.insert(Usuario);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('Admin')")
    public void update(@RequestBody Usuario usr){
        service.update(usr);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('Admin')")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

}
