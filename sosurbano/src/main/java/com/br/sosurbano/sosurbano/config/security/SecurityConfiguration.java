package com.br.sosurbano.sosurbano.config.security;

import com.br.sosurbano.sosurbano.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private TokenValidation tokenValidation;


    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(a -> a
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/roles").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/roles").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/roles/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/roles/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/chamados").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/chamados/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/chamados/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/chamados/{id}").hasRole("ADMIN")
                        .requestMatchers("/status-chamado/**").hasRole("ADMIN")
                        .requestMatchers("/usuarios/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                ).addFilterBefore(
                        tokenValidation,
                        UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    //tratando senhas
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
