package com.br.sosurbano.sosurbano.repository;

import com.br.sosurbano.sosurbano.model.ChamadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<ChamadoModel, Integer> {
}
