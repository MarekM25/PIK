package com.databasemanager.domain.service;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EntityServiceBase<Entity, DTO> implements EntityService<Entity, DTO> {
    private final Mapper mapper;

    private final Class<DTO> dtoObjectClass;

    private final Class<Entity> entityObjectClass;

    public EntityServiceBase(Class<Entity> entityObjectClass, Class<DTO> dtoObjectClass) {
        this.entityObjectClass = entityObjectClass;
        this.dtoObjectClass = dtoObjectClass;
        this.mapper = new DozerBeanMapper();
    }

    public Entity convertToEntity(DTO objectDTO) {
        return this.mapper.map(objectDTO, this.entityObjectClass);
    }

    public DTO convertToDTO(Entity objectEntity) {
        return this.mapper.map(objectEntity, this.dtoObjectClass);
    }

    public List<DTO> convertToDTOList(List<Entity> objectEntityList) {

        return objectEntityList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
