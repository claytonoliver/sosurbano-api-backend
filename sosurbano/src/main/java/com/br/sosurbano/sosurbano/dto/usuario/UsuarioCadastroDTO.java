package com.br.sosurbano.sosurbano.dto.usuario;

import com.br.sosurbano.sosurbano.model.RoleModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record UsuarioCadastroDTO(

        @NotBlank(message = "O nome não pode estar em branco")
        String nome,
        @NotBlank(message = "O E-mail não pode ser em branco")
        @Email(message = "O E-mail informado não é válido")
        String email,
        @NotBlank(message = "O telefone não pode estar em branco")
        String telefone,
        @NotBlank(message = "A senha informada não pode estar em branco")
        @Size(min = 6, max = 20, message = "A senha deve conter de 6 a 20 caracteres")
        String senha,
        @NotNull(message = "O Genero não pode estar vazio")
        Integer generoId,
        @NotNull(message = "Permissão não pode estar vazio")
        RoleModel role,
        @NotBlank(message = "CPF não pode estar vazio")
        String cpf


) {
}
