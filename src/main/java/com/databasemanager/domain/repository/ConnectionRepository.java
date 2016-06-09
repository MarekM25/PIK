package com.databasemanager.domain.repository;

import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.model.Connection;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;


@NoRepositoryBean
public interface ConnectionRepository extends RepositoryBase<Connection, Long>
{
    List<Connection> findAllByAccount(Account account);
    Connection findById(long id);
}


