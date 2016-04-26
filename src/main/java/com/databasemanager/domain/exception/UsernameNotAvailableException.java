package com.databasemanager.domain.exception;

public class UsernameNotAvailableException extends RuntimeException {

    private String username;

    public UsernameNotAvailableException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return "Login " + username + " jest już zajęty";
    }
}
