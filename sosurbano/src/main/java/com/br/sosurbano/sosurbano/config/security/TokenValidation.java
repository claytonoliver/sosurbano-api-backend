package com.br.sosurbano.sosurbano.config.security;

import com.br.sosurbano.sosurbano.repository.UsuarioRepository;
import com.br.sosurbano.sosurbano.service.AuthorizationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TokenValidation extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String autorizationHeader = request.getHeader("Authorization");

        if (autorizationHeader != null && autorizationHeader.startsWith("Bearer ")) {
            String token = autorizationHeader.replace("Bearer", "").trim();
            String login = tokenService.tokenValidation(token);

            if (login != null && !login.isEmpty()) {
                UserDetails usuario = authorizationService.loadUserByUsername(login);

                if (usuario != null) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    usuario,
                                    null,
                                    usuario.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                } else {
                    System.out.println("Usuario não encontrado para o login: " + login);
                }
            } else {
                System.out.println("Token inválido ou login não extraído do token.");
            }
        }

        filterChain.doFilter(request, response);
    }

}
