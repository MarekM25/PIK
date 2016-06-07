package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.QueryResultDTO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

@Service
public class QueryServiceImpl implements QueryService {

    public Connection createConnection() throws SQLException {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "root");
        connectionProperties.put("password", "qwerty");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", connectionProperties);
    }

    public QueryResultDTO executeQuery(String query) throws SQLException {
        QueryResultDTO queryResultDTO = new QueryResultDTO();
        Connection connection = this.createConnection();
        Statement statement = connection.createStatement();
        if (statement.execute(query)) {
            ResultSet resultSet = statement.executeQuery(query);
            queryResultDTO.setSelectQuery(true);
            queryResultDTO.setColumnsNames(getColumnNames(resultSet));
            queryResultDTO.setRows(getResultRows(resultSet));
        } else {
            queryResultDTO.setSelectQuery(false);
        }
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
