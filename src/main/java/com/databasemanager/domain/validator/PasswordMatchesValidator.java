package com.databasemanager.domain.validator;

import com.databasemanager.domain.dto.AccountDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        AccountDTO accountDTO = (AccountDTO) obj;
        String password = accountDTO.getPassword();
        return password != null && password.equals(accountDTO.getMatchingPassword());
    }
}