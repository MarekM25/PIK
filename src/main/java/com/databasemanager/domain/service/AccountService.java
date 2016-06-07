package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.AccountDTO;
import com.databasemanager.domain.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AccountService extends UserDetailsService, EntityService<Account, AccountDTO> {
    boolean isUsernameAvailable(String username);

    Account getCurrentlyLoggedInAccount();

    AccountDTO createAccount(AccountDTO accountDTO);

    PasswordEncoder getPasswordEncoder();
}
