package com.databasemanager.domain.service;

import com.databasemanager.persistence.entity.AccountEntity;
import com.databasemanager.domain.model.AccountModel;
import com.databasemanager.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public AccountModel saveAccount(AccountModel accountModel) {
        return accountRepository.save(accountModel);
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        return accountRepository.findByUsername(username) == null;
    }

    @Override
    public AccountModel createAccount(AccountModel accountModel) {
        /*AccountEntity acc = new AccountEntity();
        accountEntity.setUsername(accountModel.getUsername());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(accountModel.getPassword());
        accountEntity.setPassword(hashedPassword);*/
        return accountModel;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountModel accountModel = accountRepository.findByUsername(username);
        if (username == null) {
            return null;
        }
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        if (username.equals("admin")) {
            auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }
        String password = accountModel.getPassword();
        return new User(username, password, auth);
    }
}
