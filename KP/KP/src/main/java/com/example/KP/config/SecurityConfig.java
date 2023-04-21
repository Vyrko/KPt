package com.example.KP.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/*@EnableWebSecurity*/
public class SecurityConfig {

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/registration/**","/sing/**").permitAll()
                .and().authorizeHttpRequests().requestMatchers("/home/**","image/**")
                .authenticated().and().formLogin().and().build();
    }*/
}
