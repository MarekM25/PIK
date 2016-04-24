package com.databasemanager.persistence.repository;

import com.databasemanager.domain.repository.RepositoryBase;
import com.google.common.collect.Iterables;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryBaseImpl<Model, Entity, ID extends Serializable> implements RepositoryBase<Model, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected final Class<Entity> entityClass;

    protected final Class<Model> modelClass;

    protected final Mapper mapper;

    public RepositoryBaseImpl(Class<Entity> entityClass, Class<Model> modelClass) {
        this.entityClass = entityClass;
        this.modelClass = modelClass;
        this.mapper = new DozerBeanMapper();
    }

    @Override
    public Model save(Model model) {
        Entity entity = this.mapper.map(model, this.entityClass);
        this.entityManager.persist(entity);
        return this.mapper.map(entity, this.modelClass);
    }

    @Override
    public Iterable<Model> save(Iterable<Model> models) {
        List<Model> persistedModels = new ArrayList<Model>();
        for (Model model : models) {
            persistedModels.add(this.save(model));
        }

        return persistedModels;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Model findOne(ID id) {
        Entity entity = this.entityManager.find(this.entityClass, id);
        return this.mapper.map(entity, this.modelClass);
    }

    @Override
    public boolean exists(ID id) {
        return this.findOne(id) != null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Model> findAll() {
        List<Entity> entityList = this.entityManager.createQuery("FROM " + this.entityClass.getName()).getResultList();
        List<Model> modelList = new ArrayList<Model>();

        for (Entity entity : entityList) {
            modelList.add(this.mapper.map(entity, this.modelClass));
        }

        return modelList;
    }

    @Override
    public long count() {
        return Iterables.size(this.findAll());
    }

    @Override
    public void delete(ID id) {
        Model model = this.findOne(id);
        if (model != null) {
            this.delete(model);
        }
    }

    @Override
    public void delete(Model model) {
        this.entityManager.remove(this.mapper.map(model, this.entityClass));
    }

    @Override
    public void delete(Iterable<Model> models) {
        for (Model model : models) {
            this.delete(model);
        }
    }

    @Override
    public void deleteAll() {
        Iterable<Model> allModels = this.findAll();
        for (Model model : allModels) {
            this.delete(model);
        }
    }
}
