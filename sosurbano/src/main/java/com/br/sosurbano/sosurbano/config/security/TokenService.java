package com.br.sosurbano.sosurbano.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.br.sosurbano.sosurbano.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${my.secret.key}")
    private String secretKey;

    public String tokenGeneration(UsuarioModel usuario){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            String us = usuario.getCpf();

            String token = JWT.create()
                    .withIssuer("SOSURBANO")
                    .withSubject(usuario.getCpf())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException e){
            throw new RuntimeException("Não foi possível gerar o token!");
        }

    }

    private Instant generateExpirationDate(){
        return LocalDateTime
                .now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String tokenValidation(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
                    .withIssuer("SOSURBANO")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            // Log para verificação do problema
            System.out.println("Erro na verificação do token: " + e.getMessage());
            return null;
        }

    }

}