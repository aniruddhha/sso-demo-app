package com.ani.sso.ssodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class SsoConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login();

        http
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public ClientRegistrationRepository  clientRegistrationRepository() {
        return  new InMemoryClientRegistrationRepository(githubRegistration());
    }

    private ClientRegistration githubRegistration() {
        return CommonOAuth2Provider.GITHUB
                .getBuilder("github")
                .clientId("8cb095591c716c99838f")
                .clientSecret("0600197836c41e5c83b028ed6a2f498008209b4d")
                .build();
    }
}
