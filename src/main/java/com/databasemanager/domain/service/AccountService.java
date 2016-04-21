package com.databasemanager.domain.service;

import com.databasemanager.domain.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account saveAccount(Account account);
    Account createAccount();
}
