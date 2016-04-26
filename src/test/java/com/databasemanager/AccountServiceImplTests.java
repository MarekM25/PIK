package com.databasemanager;

import com.databasemanager.domain.model.Account;
import com.databasemanager.domain.repository.AccountRepository;
import com.databasemanager.infrastructure.service.AccountServiceImpl;
import com.databasemanager.web.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class AccountServiceImplTests {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIsUsernameAvailable() {

        Account account = new Account();
        account.setId(1L);
        account.setUsername("testuser");
        account.setPassword("Password");

        Mockito.when(this.accountRepository.findByUsername("testuser")).thenReturn(account);

        Assert.assertFalse("User with given username already exists.", this.accountService.isUsernameAvailable("testuser"));
        Assert.assertFalse("User with given username already exists (case insensitive comparison).", this.accountService.isUsernameAvailable("TestUser"));
        Assert.assertTrue("User with given username does not already exist.", this.accountService.isUsernameAvailable("testuser2"));
    }
}
