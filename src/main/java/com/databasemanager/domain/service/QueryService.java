package com.databasemanager.domain.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryService {
    ArrayList<String[]> executeSelectQuery(String query) throws SQLException;
    Connection createConnection() throws SQLException;
}
