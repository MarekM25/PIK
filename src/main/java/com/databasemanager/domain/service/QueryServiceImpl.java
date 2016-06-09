package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.dto.QueryDTO;
import com.databasemanager.domain.dto.QueryResultDTO;
import com.databasemanager.domain.model.DatabaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private ConnectionService connectionService;

    public Connection getConnection(ConnectionDTO connectionDTO) throws SQLException {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user",connectionDTO.getUsername());
        connectionProperties.put("password",connectionDTO.getPassword());
        String databaseURL=this.createDatabaseURL(connectionDTO);
        return DriverManager.getConnection(databaseURL, connectionProperties);
    }

    private String createDatabaseURL(ConnectionDTO connectionDTO){
        DatabaseType databaseType=connectionDTO.getDatabaseType();
        if(databaseType.equals(DatabaseType.MySQL))
            return this.createMySQLDatabaseUrl(connectionDTO);
        else if(databaseType.equals(DatabaseType.Oracle))
            return this.createOracleDatabaseUrl(connectionDTO);
        else if(databaseType.equals(DatabaseType.PostgreSQL))
            return this.createPostgreSQLUrl(connectionDTO);
        else if(databaseType.equals(DatabaseType.SQLServer))
            return this.createSQLServerUrl(connectionDTO);

        return null;
    }

    private String createMySQLDatabaseUrl(ConnectionDTO connectionDTO){
        StringBuilder databaseURL= new StringBuilder();
        databaseURL.append("jdbc:mysql://");
        databaseURL.append(connectionDTO.getHost());
        databaseURL.append(":");
        databaseURL.append(connectionDTO.getPort());
        databaseURL.append("/");
        databaseURL.append(connectionDTO.getInitialDatabase());
        return databaseURL.toString();
    }

    private String createOracleDatabaseUrl(ConnectionDTO connectionDTO){
        StringBuilder databaseURL= new StringBuilder();
        databaseURL.append("jdbc:oracle:thin:");
        databaseURL.append(connectionDTO.getUsername());
        databaseURL.append("/");
        databaseURL.append(connectionDTO.getPassword());
        databaseURL.append("@");
        databaseURL.append(connectionDTO.getHost());
        databaseURL.append(":");
        databaseURL.append(connectionDTO.getPort());
        databaseURL.append(":");
        databaseURL.append(connectionDTO.getInitialDatabase());
        return databaseURL.toString();
    }

    private String createPostgreSQLUrl(ConnectionDTO connectionDTO){
        StringBuilder databaseURL= new StringBuilder();
        databaseURL.append("jdbc:postgresql://");
        databaseURL.append(connectionDTO.getHost());
        databaseURL.append(":");
        databaseURL.append(connectionDTO.getPort());
        databaseURL.append("/");
        databaseURL.append(connectionDTO.getInitialDatabase());
        return databaseURL.toString();
    }

    private String createSQLServerUrl(ConnectionDTO connectionDTO){
        StringBuilder databaseURL= new StringBuilder();
        databaseURL.append("jdbc:sqlserver://");
        databaseURL.append(connectionDTO.getHost());
        databaseURL.append(";");
        databaseURL.append(connectionDTO.getUsername());
        databaseURL.append(";");
        databaseURL.append(connectionDTO.getPassword());
        return databaseURL.toString();
    }

    public QueryResultDTO executeQuery(QueryDTO queryDTO) throws SQLException {
        QueryResultDTO queryResultDTO = new QueryResultDTO();
        ConnectionDTO connectionDTO=connectionService.findConnectionById(queryDTO.getConnectionId());
        Connection connection = this.getConnection(connectionDTO);
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
