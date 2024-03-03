package com.example.manzionepropertiesauthserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {



    @Bean
    SecurityFilterChain basicSecurityFilterChain(HttpSecurity http) throws Exception {
       return http.authorizeHttpRequests(configAuthorization->configAuthorization.anyRequest().authenticated())   .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults()).build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
    return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(UserRepository userRepository){
        return userRepository::findByUsername;
    }
}
