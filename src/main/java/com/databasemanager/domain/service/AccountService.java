package com.databasemanager.domain.service;

import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.model.AccountDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account saveAccount(Account account);

    boolean isUsernameAvailable(String username);

    Account createAccount(AccountDTO accountDTO);
}
