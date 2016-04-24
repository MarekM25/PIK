package com.databasemanager.domain.repository;

import com.databasemanager.domain.model.AccountModel;
import com.databasemanager.persistence.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends RepositoryBase<AccountModel, Long> {
    AccountModel findByUsername(String username);
}
