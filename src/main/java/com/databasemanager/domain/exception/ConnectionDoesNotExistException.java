package com.databasemanager.domain.exception;


public class ConnectionDoesNotExistException extends RuntimeException
{
    public ConnectionDoesNotExistException()
    {

    }

    @Override
    public String getMessage()
    {
        return "Nie istnieje takie połączenie.";
    }
}
