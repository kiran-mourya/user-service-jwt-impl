/*

package com.example.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class ConfigSEC {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) //  Disable CSRF for API POST access
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/welcome").permitAll() // Public endpoint
                        .anyRequest().authenticated()           // Secure everything else
                )
                .httpBasic(withDefaults()); //  Enables Basic Auth

        return http.build();
    }
}
*/
