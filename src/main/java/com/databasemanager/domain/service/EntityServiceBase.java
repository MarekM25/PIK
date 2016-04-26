package com.databasemanager.domain.service;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public abstract class EntityServiceBase<Entity, DTO> {
    private final Mapper mapper;

    private final Class<DTO> dtoObjectClass;

    private final Class<Entity> entityObjectClass;

    public EntityServiceBase(Class<Entity> entityObjectClass, Class<DTO> dtoObjectClass) {
        this.entityObjectClass = entityObjectClass;
        this.dtoObjectClass = dtoObjectClass;
        this.mapper = new DozerBeanMapper();
    }

    Entity convertToEntity(DTO objectDTO) {
        return this.mapper.map(objectDTO, this.entityObjectClass);
    }

    DTO convertToDTO(Entity objectEntity) {
        return this.mapper.map(objectEntity, this.dtoObjectClass);
    }
}
