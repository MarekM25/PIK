package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.AccountDTO;
import com.databasemanager.domain.exception.UsernameNotAvailableException;
import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl extends EntityServiceBase<Account, AccountDTO> implements AccountService {

    private AccountRepository accountRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        super(Account.class, AccountDTO.class);
        this.accountRepository = accountRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public PasswordEncoder getPasswordEncoder() {
        return this.passwordEncoder;
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        return accountRepository.findByUsername(username) == null;
    }

    @Override
    @Transactional
    public AccountDTO createAccount(AccountDTO accountDTO) {
        String username = accountDTO.getUsername();
        if (!isUsernameAvailable(username)) {
            throw new UsernameNotAvailableException(username);
        }
        Account account = this.convertToEntity(accountDTO);
        account = accountRepository.save(account);
        return this.convertToDTO(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            return null;
        }

        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        /*if (username.equals("admin")) {
            auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }*/

        return new User(username, account.getPasswordHash(), auth);
    }

    private String HashPassword(String plaintextPassword) {
        return this.passwordEncoder.encode(plaintextPassword);
    }

    @Override
    protected Account convertToEntity(AccountDTO accountDTO) {
        Account account = super.convertToEntity(accountDTO);
        account.setPasswordHash(this.HashPassword(accountDTO.getPassword()));
        return account;
    }
}
