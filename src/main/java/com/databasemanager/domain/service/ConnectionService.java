package com.databasemanager.domain.service;


import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.model.Connection;

import java.util.List;

public interface ConnectionService extends EntityService<Connection, ConnectionDTO>
{
    ConnectionDTO createConnection(ConnectionDTO connectionDTO);

    List<ConnectionDTO> findConnectionsForCurrentAccount();

    ConnectionDTO findConnectionById(long id);

    void deleteConnection(long id);
}
