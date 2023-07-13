/*
package com.app.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class OrgWebSecurityConfiguration {
    @Autowired
    private OrganizationDetailsServiceImpl organizationDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    @CrossOrigin
    public SecurityFilterChain orgSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .securityMatchers((matcher) -> matcher
                        .requestMatchers("/auth//org").anyRequest())
                .authorizeHttpRequests()
                .requestMatchers("/auth/register/**")
                .permitAll()
                .requestMatchers("/auth/login/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/login/org")
                .loginProcessingUrl("/auth/login/org")
                .defaultSuccessUrl("/auth/org-login-success", true)
                .permitAll()
                .and()
                .authenticationManager(orgAuthenticationManager(http))
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/auth/login?logout")
                .permitAll();
        return http.build();
    }

    @Bean
    public AuthenticationManager orgAuthenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(orgAuthProvider())
                .build();
    }

    @Bean
    public DaoAuthenticationProvider orgAuthProvider() {
        DaoAuthenticationProvider orgAuthenticationProvider = new DaoAuthenticationProvider();
        orgAuthenticationProvider.setUserDetailsService(organizationDetailsService);
        orgAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return orgAuthenticationProvider;
    }
}
 */