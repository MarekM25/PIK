package com.databasemanager.domain.dto;

/**
 * Created by Pawel Wiszenko on 6/6/16.
 */

public class ConnectionDTO {
    private String host;
    private short port;
    private String database;
    @Size(min = 5, max = 25, message = "Login musi mieć co najmniej 5 i co najwyżej 25 znaków.")
    private String username;
    @Size(min = 5, max = 25, message = "Hasło musi mieć co najmniej 5 i co najwyżej 25 znaków.")
    private String password;

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public short getPort()
    {
        return port;
    }

    public void setPort(short port)
    {
        this.port = port;
    }

    public String getdatabase()
    {
        return database;
    }

    public void setDatabase(String database)
    {
        this.database = database;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}