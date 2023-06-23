package com.app.server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers(HttpMethod.GET, "/login")
                .permitAll()
                .requestMatchers(HttpMethod.POST, "/login")
                .permitAll()
                .requestMatchers(HttpMethod.GET, "/")
                .permitAll()
                .anyRequest()
                .authenticated())
                .logout((logout) -> logout
                        .permitAll()
                        .logoutSuccessUrl("/login"));
        http.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
