package com.databasemanager.domain.repository;

import com.databasemanager.domain.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    AccountEntity findByUsername(String username);
}
