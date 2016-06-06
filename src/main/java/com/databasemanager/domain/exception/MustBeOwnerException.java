package com.databasemanager.domain.exception;


public class MustBeOwnerException extends RuntimeException
{
    public MustBeOwnerException()
    {

    }

    @Override
    public String getMessage()
    {
        return "Nie mozna usunac polaczenia stworzonego przez innego uzytkownika";
    }
}

