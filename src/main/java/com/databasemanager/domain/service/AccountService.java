package com.databasemanager.domain.service;

import com.databasemanager.domain.model.Account;

public interface AccountService {
    Account getAccountByUsername(String username);
}
