package com.databasemanager.persistence.repository;

import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AccountRepositoryImpl extends RepositoryBaseImpl<Account, Long> implements AccountRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public AccountRepositoryImpl(@SuppressWarnings("SpringJavaAutowiringInspection") EntityManager entityManager) {
        super(Account.class, entityManager);
    }

    public Account findByUsername(String username) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> cq = builder.createQuery(Account.class);
        Root<Account> accountRoot = cq.from(Account.class);
        cq.where(builder.equal(accountRoot.get("username"), username));
        cq.select(accountRoot);

        List<Account> resultList = this.entityManager.createQuery(cq).getResultList();
        if (resultList.size() <= 0) {
            return null;
        }

        return resultList.get(0);
    }
}
