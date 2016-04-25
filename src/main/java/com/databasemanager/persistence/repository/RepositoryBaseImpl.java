package com.databasemanager.persistence.repository;


import com.databasemanager.domain.repository.RepositoryBase;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

@NoRepositoryBean
public abstract class RepositoryBaseImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements RepositoryBase<T, ID> {
    public RepositoryBaseImpl(Class<T> domainEntity, EntityManager entityManager) {
        super(domainEntity, entityManager);
    }
}
