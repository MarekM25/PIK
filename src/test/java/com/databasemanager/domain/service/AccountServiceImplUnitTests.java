package com.databasemanager.domain.service;

import com.databasemanager.domain.dto.AccountDTO;
import com.databasemanager.domain.exception.UsernameNotAvailableException;
import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.repository.AccountRepository;
import com.databasemanager.web.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class AccountServiceImplUnitTests {

    @Mock
    private AccountRepository accountRepository;
    private AccountService accountService;

    @Before
    public void setUpAccountService() {
        accountService = new AccountServiceImpl(accountRepository);
    }

    @Before
    public void setAccountRepositoryFindByUsernameMockConfiguration() {
        Mockito.when(accountRepository.findByUsername(Matchers.any(String.class))).thenAnswer(new Answer<Account>() {
            public Account answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<String> notAvailableUsernames = new ArrayList<>();
                notAvailableUsernames.add("UsernameExists");
                notAvailableUsernames.add("UsernameExists2");
                notAvailableUsernames.add("UsernameExists3");

                String givenUsername = (String) invocationOnMock.getArguments()[0];
                if (!notAvailableUsernames.contains(givenUsername)) {
                    return null;
                }

                Account account = new Account();
                account.setId(1L);
                account.setUsername(givenUsername);
                account.setPasswordHash("HashedPassword");

                return account;
            }
        });
    }

    @Before
    public void setAccountRepositorySaveMockConfiguration() {
        Mockito.when(accountRepository.save(Matchers.any(Account.class))).thenAnswer(new Answer<Account>() {
            public Account answer(InvocationOnMock invocationOnMock) throws Throwable {
                return (Account) invocationOnMock.getArguments()[0];
            }
        });
    }

    @Test
    public void testIsUsernameAvailable() {
        Assert.assertFalse("User with given username already exists.", this.accountService.isUsernameAvailable("UsernameExists"));
        Assert.assertFalse("User with given username already exists.", this.accountService.isUsernameAvailable("UsernameExists2"));
        Assert.assertTrue("User with given username does not already exist (case insensitive comparison).", this.accountService.isUsernameAvailable("usernameexist"));
        Assert.assertTrue("User with given username does not already exist.", this.accountService.isUsernameAvailable("testUsername"));
    }

    @Test
    public void testCreateAccount() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("user");
        accountDTO.setPassword("password");
        accountDTO.setMatchingPassword("password");

        Assert.assertEquals("Account created successfully", accountDTO, accountService.createAccount(accountDTO));
    }

    @Test(expected = UsernameNotAvailableException.class)
    public void testCreateAccountException() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("UsernameExists");
        accountDTO.setPassword("password");
        accountDTO.setMatchingPassword("password");

        this.accountService.createAccount(accountDTO);
    }

    @Test
    public void testLoadUserByUsername() {
        Assert.assertEquals("User with given username exists.", "UsernameExists", this.accountService.loadUserByUsername("UsernameExists").getUsername());
        Assert.assertEquals("User with given username exists.", "UsernameExists3", this.accountService.loadUserByUsername("UsernameExists3").getUsername());
        Assert.assertNull("User with given username does not exist (case insensitive comparison).", this.accountService.loadUserByUsername("usernameexists"));
        Assert.assertNull("User with given username does not exist.", this.accountService.loadUserByUsername("testUser"));
    }

    @Test
    public void testConvertToEntity() {

    }
}
