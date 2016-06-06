package com.databasemanager.domain.model;

import javax.persistence.*;

@Entity
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String host;
    @Column(nullable = false)
    private short port;
    @Column(nullable = false)
    private String initialDatabase;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private DatabaseType databaseType;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

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

    public DatabaseType getDatabaseType()
    {
        return this.databaseType;
    }

    public void setDatabaseType(DatabaseType databaseType)
    {
        this.databaseType = databaseType;
    }
}



