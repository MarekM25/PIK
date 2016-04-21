package com.databasemanager.web.controller;

import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/login")
    public String login() {
        return "account/login";
    }

    @RequestMapping("/welcome")
    public String afterSuccessfulLogin() {
        return "account/welcome";
    }

    @RequestMapping("/create")
    public String create() {
        Account account = accountService.createAccount();
        accountService.saveAccount(account);
        return "account/create";
    }

    @RequestMapping("/create-default")
    public String createDefaultAccount() {
        Account account = accountService.createAccount();
        accountService.saveAccount(account);
        return "account/create";
    }
}
