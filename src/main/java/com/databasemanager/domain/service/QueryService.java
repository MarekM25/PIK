package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.QueryResultDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface QueryService {
    QueryResultDTO executeQuery(String query) throws SQLException;

    Connection createConnection() throws SQLException;
}
