package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.dto.QueryDTO;
import com.databasemanager.domain.dto.QueryResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private ConnectionService connectionService;

    public Connection createConnection(ConnectionDTO connectionDTO) throws SQLException {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user",connectionDTO.getUsername());
        connectionProperties.put("password",connectionDTO.getPassword());
        String databaseURL=this.createDatabaseURL(connectionDTO);
        return DriverManager.getConnection(databaseURL, connectionProperties);
    }

    private String createDatabaseURL(ConnectionDTO connectionDTO){
        StringBuilder databaseURL= new StringBuilder();
        databaseURL.append("jdbc:mysql://");
        databaseURL.append(connectionDTO.getHost());
        databaseURL.append(":");
        databaseURL.append(connectionDTO.getPort());
        databaseURL.append("/");
        databaseURL.append(connectionDTO.getInitialDatabase());
        return databaseURL.toString();
    }

    public QueryResultDTO executeQuery(QueryDTO queryDTO) throws SQLException {
        QueryResultDTO queryResultDTO = new QueryResultDTO();
        ConnectionDTO connectionDTO=connectionService.findConnectionById(queryDTO.getConnectionId());
        Connection connection = this.createConnection(connectionDTO);
        Statement statement = connection.createStatement();
        String query=queryDTO.getQueryText();
        if (statement.execute(query)) {
            ResultSet resultSet = statement.executeQuery(query);
            queryResultDTO.setSelectQuery(true);
            queryResultDTO.setColumnsNames(getColumnNames(resultSet));
            queryResultDTO.setRows(getResultRows(resultSet));
        } else {
            queryResultDTO.setSelectQuery(false);
        }
        connection.close();
        return queryResultDTO;
    }

    private String[] getColumnNames(ResultSet resultSet) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();
        String[] columnsNames = new String[columnsNumber];
        for (int i = 1; i <= columnsNumber; i++)
            columnsNames[i - 1] = resultSetMetaData.getColumnName(i);
        return columnsNames;
    }

    private ArrayList<String[]> getResultRows(ResultSet resultSet) throws SQLException {
        ArrayList<String[]> results = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            String[] row = new String[columnsNumber];
            for (int i = 1; i <= columnsNumber; i++)
                row[i - 1] = resultSet.getString(i);
            results.add(row);
        }
        return results;
    }
}
