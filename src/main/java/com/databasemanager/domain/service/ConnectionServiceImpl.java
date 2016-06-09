package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.exception.ConnectionDoesNotExistException;
import com.databasemanager.domain.exception.MustBeOwnerException;
import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.model.Connection;
import com.databasemanager.domain.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConnectionServiceImpl extends EntityServiceBase<Connection, ConnectionDTO> implements ConnectionService
{
    @Autowired
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
        connection.setAccount(this.accountService.getCurrentlyLoggedInAccount());
        connection = connectionRepository.save(connection);
        return this.convertToDTO(connection);
    }

    @Override
    public List<ConnectionDTO> findConnectionsForCurrentAccount() {
        Account account = this.accountService.getCurrentlyLoggedInAccount();

        List<Connection> connectionList = this.connectionRepository.findAllByAccount(account);

        return this.convertToDTOList(connectionList);
    }

    @Override
    public ConnectionDTO findConnectionById(long id){
        Connection connection=this.connectionRepository.findById(id);
        return  this.convertToDTO(connection);
    }

    @Override
    @Transactional
    public void deleteConnection(long id)
    {
        Connection connection = connectionRepository.findOne(id);

        if (connection == null) {
            throw new ConnectionDoesNotExistException();
        }

        Account connectionOwnerAccount = connection.getAccount();
        Account currentAccount = accountService.getCurrentlyLoggedInAccount();

        if (!connectionOwnerAccount.equals(currentAccount))
        {
            throw new MustBeOwnerException();
        }

        connectionRepository.delete(id);
    }
}


