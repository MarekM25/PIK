package com.databasemanager.domain.repository;

import com.databasemanager.domain.model.Account;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AccountRepository extends RepositoryBase<Account, Long> {
    Account findByUsername(String username);
}
