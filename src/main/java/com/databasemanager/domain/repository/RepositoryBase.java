package com.databasemanager.domain.repository;


import java.io.Serializable;

public interface RepositoryBase<Model, ID extends Serializable> {
    Model save(Model model);

    Iterable<Model> save(Iterable<Model> models);

    Model findOne(ID id);

    boolean exists(ID id);

    Iterable<Model> findAll();

    long count();

    void delete(ID id);

    void delete(Model model);

    void delete(Iterable<Model> models);

    void deleteAll();
}
