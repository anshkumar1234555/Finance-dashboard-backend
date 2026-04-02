package com.finance.dashboard.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // Allow H2 Console
                .requestMatchers("/h2-console/**").permitAll()

                // GET → all roles
                .requestMatchers("/api/records").hasAnyRole("VIEWER", "ANALYST", "ADMIN")

                // POST, PUT, DELETE → only ADMIN
                .requestMatchers("/api/records/**").hasRole("ADMIN")

                // everything else needs login
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());

            http.headers(headers -> headers.frameOptions(frame -> frame.disable()));
        return http.build();
    }
}