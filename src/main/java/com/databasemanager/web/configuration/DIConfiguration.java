package com.databasemanager.web.configuration;

import com.databasemanager.domain.service.AccountService;
import com.databasemanager.infrastructure.service.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfiguration {

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl();
    }
}
