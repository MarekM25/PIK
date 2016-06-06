package com.databasemanager.domain.repository;

import com.databasemanager.domain.model.Connection;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;


@NoRepositoryBean
public interface ConnectionRepository extends RepositoryBase<Connection, Long>
{
    List<Connection> findByUsername(String username);

    Connection findById(long id);

    void deleteById(long id);
}


