package com.br.sosurbano.sosurbano.dto.chamado;

import java.time.LocalDateTime;

public record ChamadoCadastroDTO(

    Integer chamadoId,
    Integer usuarioId,
    Integer statusId,
    LocalDateTime dataChamado,
    String descricao,
    Double latitude,
    Double longitude
) {
}
