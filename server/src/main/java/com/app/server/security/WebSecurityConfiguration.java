package com.app.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private OrganizationDetailsServiceImpl organizationDetailsService;

    @Bean
    @CrossOrigin(origins = "http://localhost:5173")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .cors()
                .and()
                .securityMatchers((matcher) -> matcher
                        .requestMatchers("/auth/*/*").anyRequest())
                .authorizeHttpRequests()
                .requestMatchers("/auth/register/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/login")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/auth/login-success", true)
                .permitAll()
                .and()
                .authenticationManager(authenticationManager(http))
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/auth/login?logout")
                .permitAll();
        return http.build();
    }

    @Bean
    @Primary
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(userAuthProvider())
                .authenticationProvider(orgAuthProvider())
                .build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider userAuthProvider() {
        DaoAuthenticationProvider userAuthenticationProvider = new DaoAuthenticationProvider();
        userAuthenticationProvider.setUserDetailsService(userDetailsService);
        userAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return userAuthenticationProvider;
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
        orgAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return orgAuthenticationProvider;
    }
}
