package com.br.sosurbano.sosurbano.controller;

import com.br.sosurbano.sosurbano.config.security.TokenService;
import com.br.sosurbano.sosurbano.dto.TokenDto;
import com.br.sosurbano.sosurbano.dto.usuario.LoginDto;
import com.br.sosurbano.sosurbano.dto.usuario.UsuarioCadastroDTO;
import com.br.sosurbano.sosurbano.dto.usuario.UsuarioExibicaoDTO;
import com.br.sosurbano.sosurbano.model.UsuarioModel;
import com.br.sosurbano.sosurbano.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto) {

        UsernamePasswordAuthenticationToken userNamePassword = new UsernamePasswordAuthenticationToken(
                loginDto.cpf(),
                loginDto.senha());

        Authentication authentication = authenticationManager.authenticate(userNamePassword);

        String token = tokenService.tokenGeneration((UsuarioModel) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDto(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO registrar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO){
        UsuarioExibicaoDTO usuarioSalvo = null;
        usuarioSalvo = service.salvarUsuario(usuarioCadastroDTO);
        return usuarioSalvo;
    }
}
