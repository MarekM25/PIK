package com.databasemanager.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.databasemanager")
public class DatabaseManagerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DatabaseManagerApplication.class, args);
	}

	@Override
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(DatabaseManagerApplication.class);
	}
}
