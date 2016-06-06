package com.databasemanager.domain.repository;

import com.databasemanager.domain.model.Connection;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface ConnectionRepository extends RepositoryBase<Connection, Long>
{
    Connection findByUsername(String username);

    void deleteById(Long id);
}


