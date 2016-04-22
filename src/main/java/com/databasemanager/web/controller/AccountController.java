package com.databasemanager.web.controller;

import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.model.AccountDTO;
import com.databasemanager.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/welcome")
    public String afterSuccessfulLogin() {
        return "account/welcome";
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public String registerAccount(@ModelAttribute AccountDTO accountDTO) {
        return "account/create";
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String processRegisterNewAccountForm(@ModelAttribute @Valid AccountDTO accountDTO, BindingResult result){
        if(result.hasErrors()){
            return "account/create";
        }
        Account account=accountService.createAccount(accountDTO);
        accountService.saveAccount(account);
        return "home";
    }
}
