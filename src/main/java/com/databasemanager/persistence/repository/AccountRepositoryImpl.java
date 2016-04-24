package com.databasemanager.persistence.repository;

import com.databasemanager.domain.model.AccountModel;
import com.databasemanager.persistence.entity.AccountEntity;
import com.databasemanager.domain.repository.AccountRepository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl extends RepositoryBaseImpl<AccountModel, AccountEntity, Long> implements AccountRepository {

    public AccountRepositoryImpl() {
        super(AccountEntity.class, AccountModel.class);
    }

    public AccountModel findByUsername(String username) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<AccountEntity> cq = builder.createQuery(AccountEntity.class);
        Root<AccountEntity> accountRoot = cq.from(AccountEntity.class);

        cq.where(builder.equal(accountRoot.get("username"), username));

        cq.select(accountRoot);


        List resultList = this.entityManager.createQuery(cq).getResultList();
        if (resultList.size() > 0) {
            return this.mapper.map(resultList.get(0), this.modelClass);
        }

        return null;
    }
}
