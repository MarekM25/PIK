package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.ConnectionDTO;
//import com.databasemanager.domain.exception.UsernameNotAvailableException;
import com.databasemanager.domain.model.Connection;
import com.databasemanager.domain.repository.ConnectionRepository;

import java.util.List;

@Service
public class ConnectionServiceImpl extends EntityServiceBase<Connection, ConnectionDTO> implements ConnectionService
{

    private ConnectionRepository connectionRepository;

    @Autowired
    public ConnectionServiceImpl(ConnectionRepository connectionRepository) {
        super(Connection.class, ConnectionDTO.class);
        this.connectionRepository = connectionRepository;
    }


    @Override
    @Transactional
    public ConnectionDTO createConnection(ConnectionDTO connectionDTO)
    {
        Connection connection = super.convertToEntity(connectionDTO);
        connection = connectionRepository.save(connection);
        return this.convertToDTO(connection);
    }
}


