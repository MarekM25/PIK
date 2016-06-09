package com.databasemanager.persistence.repository;

import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.model.Connection;
import com.databasemanager.domain.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ConnectionRepositoryImpl extends RepositoryBaseImpl<Connection, Long> implements ConnectionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ConnectionRepositoryImpl(@SuppressWarnings("SpringJavaAutowiringInspection") EntityManager entityManager) {
        super(Connection.class, entityManager);
    }

    public List<Connection> findAllByAccount(Account account) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Connection> cq = builder.createQuery(Connection.class);
        Root<Connection> connectionRoot = cq.from(Connection.class);
        cq.where(builder.equal(connectionRoot.get("account"), account));
        cq.select(connectionRoot);

        return this.entityManager.createQuery(cq).getResultList();
    }

    public Connection findById(long id){
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Connection> cq = builder.createQuery(Connection.class);
        Root<Connection> connectionRoot = cq.from(Connection.class);
        cq.where(builder.equal(connectionRoot.get("id"), id));
        cq.select(connectionRoot);

        List<Connection> resultList = this.entityManager.createQuery(cq).getResultList();
        if (resultList.size() <= 0) {
            return null;
        }

        return resultList.get(0);
    }
}
