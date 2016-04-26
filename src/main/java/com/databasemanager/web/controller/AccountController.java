package com.databasemanager.web.controller;

import com.databasemanager.domain.dto.AccountDTO;
import com.databasemanager.domain.exception.UsernameNotAvailableException;
import com.databasemanager.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController extends ControllerBase {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String afterSuccessfulLogin() {
        return "account/welcome";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String accountCreate(@ModelAttribute AccountDTO accountDTO) {
        return "/account/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String accountCreatePost(@ModelAttribute @Valid AccountDTO accountDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "/account/create";
        }

        try {
            accountService.createAccount(accountDTO);
        } catch (UsernameNotAvailableException usernameException) {
            result.addError(new FieldError("username", "username", usernameException.getMessage()));
            return "/account/create";
        }
        return "redirect:/home";
    }
}
