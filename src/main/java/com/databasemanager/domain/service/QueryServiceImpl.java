package com.databasemanager.domain.service;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

@Service
public class QueryServiceImpl implements QueryService {

    public Connection createConnection() throws SQLException {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "username");
        connectionProperties.put("password", "password");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/databasemanager", connectionProperties);
    }

    public ArrayList<String[]> executeSelectQuery(String query) throws SQLException {
        Connection connection = this.createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return parseQueryResultSet(resultSet);
    }

    private ArrayList<String[]> parseQueryResultSet(ResultSet resultSet) throws SQLException{
        ArrayList<String[]> results = new ArrayList<>();
        results.add(getColumnNames(resultSet));
        results.addAll(getResultRows(resultSet));
        return results;
    }

    private String[] getColumnNames(ResultSet resultSet) throws SQLException{
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();
        String[] columnsNames = new String[columnsNumber];
        for (int i = 1; i <= columnsNumber; i++)
            columnsNames[i - 1] = resultSetMetaData.getColumnName(i);
        return columnsNames;
    }

    private ArrayList<String[]> getResultRows(ResultSet resultSet) throws SQLException{
        ArrayList<String[]> results= new ArrayList<>();
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
