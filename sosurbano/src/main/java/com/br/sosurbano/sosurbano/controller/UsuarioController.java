package com.br.sosurbano.sosurbano.controller;

import com.br.sosurbano.sosurbano.dto.usuario.UsuarioCadastroDTO;
import com.br.sosurbano.sosurbano.dto.usuario.UsuarioExibicaoDTO;
import com.br.sosurbano.sosurbano.service.UsuarioService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    @PermitAll
    public UsuarioExibicaoDTO salvar(@RequestBody @Valid UsuarioCadastroDTO usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Page<UsuarioExibicaoDTO> listarUsuarios(Pageable pagina) {
        return usuarioService.listarTodosUsuarios(pagina);
    }

    @GetMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDTO buscarUsuarioPorId(@PathVariable Long id){
        return usuarioService.buscarUsuarioPorId(id);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDTO atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioCadastroDTO usuarioAtualizadoDTO) {
        return usuarioService.updateUsuario(id, usuarioAtualizadoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}
