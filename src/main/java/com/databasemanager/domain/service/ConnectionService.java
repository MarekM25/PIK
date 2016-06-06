package com.databasemanager.domain.service;


import com.databasemanager.domain.dto.ConnectionDTO;

public interface ConnectionService
{
    ConnectionDTO createConnection(ConnectionDTO connectionDTO);

    boolean deleteConnection(long id);
}
