package com.sunonrails.ggpserver.service;

import com.sunonrails.ggpserver.model.Account;
import com.sunonrails.ggpserver.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    @Transactional
    public Account save(Account user){
        return repo.save(user);
    }
}
