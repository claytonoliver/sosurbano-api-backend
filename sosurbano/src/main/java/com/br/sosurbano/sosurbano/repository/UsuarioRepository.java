package com.br.sosurbano.sosurbano.repository;

import com.br.sosurbano.sosurbano.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    UserDetails findByCpf(String Cpf);
}