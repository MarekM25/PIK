package com.databasemanager.domain.service;

import com.databasemanager.persistence.entity.AccountEntity;
import com.databasemanager.domain.model.AccountModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    AccountModel saveAccount(AccountModel accountModel);

    boolean isUsernameAvailable(String username);

    AccountModel createAccount(AccountModel accountModel);
}
