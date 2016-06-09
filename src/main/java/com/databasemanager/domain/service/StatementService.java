package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.dto.StatementDTO;
import com.databasemanager.domain.dto.StatementResultDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface StatementService {
    StatementResultDTO executeStatement(StatementDTO statementDTO) throws SQLException;

    Connection getConnection(ConnectionDTO connectionDTO) throws SQLException;
}
