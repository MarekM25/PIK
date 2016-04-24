package com.databasemanager.domain.model;


import com.databasemanager.domain.validator.PasswordMatches;
import com.databasemanager.domain.validator.UsernameAvailable;

import javax.validation.constraints.Size;

@PasswordMatches
public class AccountModel {
    @Size(min = 5, max = 25, message = "Login musi mieć co najmniej 5 i co najwyżej 25 znaków.")
    @UsernameAvailable
    private String username;
    @Size(min = 5, max = 25, message = "Hasło musi mieć co najmniej 5 i co najwyżej 25 znaków.")
    private String password;
    private String matchingPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        //TODO Store password hashed
        //TODO Something like this.hashedPassword = HashService(password)
        this.password = password;
    }

    //TODO Add checkPassword method

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
