package com.databasemanager.domain.validator;

import com.databasemanager.domain.model.AccountModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        AccountModel accountModel = (AccountModel) obj;
        return accountModel.getPassword().equals(accountModel.getMatchingPassword());
    }
}