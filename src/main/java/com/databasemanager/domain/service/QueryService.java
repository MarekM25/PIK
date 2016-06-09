package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.dto.QueryDTO;
import com.databasemanager.domain.dto.QueryResultDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface QueryService {
    QueryResultDTO executeQuery(QueryDTO queryDTO) throws SQLException;

    Connection createConnection(ConnectionDTO connectionDTO) throws SQLException;
}
