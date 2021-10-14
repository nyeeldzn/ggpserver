package com.sunonrails.ggpserver.repositories;

import com.sunonrails.ggpserver.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findOneByUsername (String username);

}
