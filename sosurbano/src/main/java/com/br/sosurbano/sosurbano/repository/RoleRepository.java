package com.br.sosurbano.sosurbano.repository;

import com.br.sosurbano.sosurbano.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Integer> {
    boolean existsByDescricao(String descricao);
}
