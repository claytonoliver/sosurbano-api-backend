package com.br.sosurbano.sosurbano.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatusChamadoDTO {

    private Integer statusId;
    private String statusNome;
    private String descricao;

    public StatusChamadoDTO() {
    }
}
