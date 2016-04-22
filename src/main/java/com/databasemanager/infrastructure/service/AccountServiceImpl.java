package com.databasemanager.infrastructure.service;

import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.model.AccountDTO;
import com.databasemanager.domain.repository.AccountRepository;
import com.databasemanager.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        return accountRepository.findByUsername(username) == null;
    }

    @Override
    public Account createAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setUsername(accountDTO.getUsername());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(accountDTO.getPassword());
        account.setPassword(hashedPassword);
        return account;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (username == null) {
            return null;
        }
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        if (username.equals("admin")) {
            auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }
        String password = account.getPassword();
        return new User(username, password, auth);
    }
}
