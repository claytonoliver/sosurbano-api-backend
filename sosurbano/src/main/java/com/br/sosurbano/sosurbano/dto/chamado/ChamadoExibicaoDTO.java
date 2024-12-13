package com.br.sosurbano.sosurbano.dto.chamado;


import com.br.sosurbano.sosurbano.model.ChamadoModel;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ChamadoExibicaoDTO {
    private Integer chamadoId;
    private Integer usuarioId;
    private Integer statusId;
    private LocalDateTime dataChamado;
    private String descricao;
    private Double latitude;
    private Double longitude;

    public ChamadoExibicaoDTO(ChamadoModel chamado) {
        this.chamadoId = chamado.getChamadoId();
        this.usuarioId = chamado.getUsuarioId();
        this.statusId = chamado.getStatusId();
        this.dataChamado = chamado.getDataChamado();
        this.descricao = chamado.getDescricao();
        this.latitude = chamado.getLatitude();
        this.longitude = chamado.getLongitude();
    }
}
