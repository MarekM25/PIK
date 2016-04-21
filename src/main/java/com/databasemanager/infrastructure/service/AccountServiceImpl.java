package com.databasemanager.infrastructure.service;

import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.service.AccountService;

public class AccountServiceImpl implements AccountService {

    public Account getAccountByUsername(String username) {
        Account account = new Account();
        account.setUsername(username);
        account.setEmail("trolololo@stud.elka.pw.edu.pl");
        account.setPassword("Dupa1");
        return account;
    }
}
