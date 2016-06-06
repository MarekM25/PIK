package com.databasemanager.domain.dto;

import com.databasemanager.domain.model.DatabaseType;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;

public class ConnectionDTO {
    private long id;

    private AccountDTO account;

    @Size(min = 1, max = 255, message = "Host nie może być pusty i może składać się z co najwyżej 255 znaków.")
    private String host;

    @Range(min=1, max=65535, message = "Port musi być liczbą w zakresie 1-65535.")
    private short port;

    @Size(min = 1, max = 255, message = "Nazwa bazy nie może być pusta i może składać się z co najwyżej 255 znaków.")
    private String initialDatabase;

    @Size(min = 1, max = 255, message = "Nazwa użytkownika nie może być pusta i może składać się z co najwyżej 255 znaków.")
    private String username;

    @Size(min = 1, max = 255, message = "Hasło nie może być puste i może składać się z co najwyżej 255 znaków.")
    private String password;

    private DatabaseType databaseType;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountDTO getAccount()
    {
        return this.account;
    }

    public void setAccount(AccountDTO account)
    {
        this.account = account;
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

    public DatabaseType getDatabaseType() {
        return this.databaseType;
    }

    public void setDatabaseType(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }
}