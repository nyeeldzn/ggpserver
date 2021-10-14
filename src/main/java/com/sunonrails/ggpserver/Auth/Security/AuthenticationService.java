package com.sunonrails.ggpserver.Auth.Security;

import com.sunonrails.ggpserver.model.Account;
import org.springframework.security.core.userdetails.User;
import com.sunonrails.ggpserver.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private AccountRepository repo;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Account u = repo.findOneByUsername(username);
        System.out.println(u.toString());
        if(u == null){
            throw new UsernameNotFoundException("Nao foi encontrado User com nome: " + username);
        }

        User user = createAccount(u);

        return user;
    }

    private User createAccount(Account u){
        return new User(u.getUsername(),u.getPass(), createAuthorities(u));
    }

    private Collection<GrantedAuthority> createAuthorities(Account u){
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + u.getRole()));
        return authorities;
    }

}
