package com.databasemanager.domain.validator;

import com.databasemanager.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class UsernameAvailableValidator implements ConstraintValidator<UsernameAvailable, Object> {

    @Autowired
    private AccountService accountService;

    @Override
    public void initialize(UsernameAvailable constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        String username = (String) obj;
        return accountService.isUsernameAvailable(username);
    }
}