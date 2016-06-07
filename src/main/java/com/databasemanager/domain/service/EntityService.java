package com.databasemanager.domain.service;

import java.util.List;

public interface EntityService<Entity, DTO> {
    Entity convertToEntity(DTO objectDTO);

    DTO convertToDTO(Entity objectEntity);

    List<DTO> convertToDTOList(List<Entity> objectEntityList);
}
