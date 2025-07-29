package com.personal.rest_server.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@TestConfiguration
@EnableAutoConfiguration
public class TestSecurityConfig {
	
	public TestSecurityConfig() {
        System.out.println("🧪 TestConfig loaded!");
    }
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withUsername("testuser")
                .password("{noop}password") // {noop} para sin codificar
                .roles("ADMIN")
                .build()
        );
    }

}
