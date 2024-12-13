package com.br.sosurbano.sosurbano.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank(message = "Cpf Não pode ser vazio")
        String cpf,
        @NotBlank(message = "A senha não pode estar vazia")
        String senha
) {

}
