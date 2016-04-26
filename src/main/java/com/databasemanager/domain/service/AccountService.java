package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.AccountDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AccountService extends UserDetailsService {
    boolean isUsernameAvailable(String username);

    AccountDTO createAccount(AccountDTO accountDTO);

    PasswordEncoder getPasswordEncoder();
}
