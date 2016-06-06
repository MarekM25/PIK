package com.databasemanager.domain.dto;

import com.databasemanager.domain.model.DatabaseType;

public class ConnectionDTO {
    private String host;

    private short port;

    private String initialDatabase;

    private String username;

    private String password;

    private DatabaseType databaseType;

    public String getHost()
    {
        return this.host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public short getPort()
    {
        return this.port;
    }

    public void setPort(short port)
    {
        this.port = port;
    }

    public String getInitialDatabase()
    {
        return this.initialDatabase;
    }

    public void setInitialDatabase(String initialDatabase)
    {
        this.initialDatabase = initialDatabase;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public DatabaseType getDatabaseType() {
        return this.databaseType;
    }

    public void setDatabaseType(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }
}