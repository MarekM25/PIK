package com.databasemanager.persistence.repository;

import com.databasemanager.domain.entity.AccountEntity;
import com.databasemanager.domain.repository.AccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositoryImpl extends AccountRepository {
    AccountEntity findByUsername(String username);
}
