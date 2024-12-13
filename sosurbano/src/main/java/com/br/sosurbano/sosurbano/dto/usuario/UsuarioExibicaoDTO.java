package com.br.sosurbano.sosurbano.dto.usuario;

import com.br.sosurbano.sosurbano.model.RoleModel;
import com.br.sosurbano.sosurbano.model.UsuarioModel;

public record UsuarioExibicaoDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        Integer genero,
        String cpf,
        RoleModel role
) {
    public UsuarioExibicaoDTO(UsuarioModel usuarioModel) {
        this(
                usuarioModel.getId(),
                usuarioModel.getNome(),
                usuarioModel.getEmail(),
                usuarioModel.getTelefone(),
                usuarioModel.getGeneroId(),
                usuarioModel.getCpf(),
                usuarioModel.getRole()
        );
    }
}
