package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.exception.MustBeOwnerException;
import com.databasemanager.domain.model.Connection;
import com.databasemanager.domain.repository.ConnectionRepository;

@Service
public class ConnectionServiceImpl extends EntityServiceBase<Connection, ConnectionDTO> implements ConnectionService
{

    private AccountService accountService;
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


    @Override
    @Transactional
    public void deleteConnection(long id)
    {
        Connection connection = connectionRepository.findById(id);

        String connectionUsername = connection.getUsername();
        String currentUsername = accountService.getCurrentlyLoggedInAccount().getUsername();

        if (!currentUsername.equals(connectionUsername))
        {
            throw new MustBeOwnerException();
        }

        connectionRepository.deleteById(id);
    }
}


