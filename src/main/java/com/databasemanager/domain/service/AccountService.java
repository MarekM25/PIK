package com.databasemanager.domain.service;

import com.databasemanager.domain.entity.AccountEntity;
import com.databasemanager.domain.model.AccountModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    AccountEntity saveAccount(AccountEntity accountEntity);

    boolean isUsernameAvailable(String username);

    AccountEntity createAccount(AccountModel accountModel);
}
