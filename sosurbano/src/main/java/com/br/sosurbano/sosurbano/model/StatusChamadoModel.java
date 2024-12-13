package com.br.sosurbano.sosurbano.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SOU_STATUS_CHAMADO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StatusChamadoModel {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_STATUS_CHAMADO"
    )
    @SequenceGenerator(
            name = "SEQ_STATUS_CHAMADO",
            sequenceName = "SEQ_STATUS_CHAMADO",
            allocationSize = 1
    )
    @Column(name = "STATUS_ID")
    private Integer statusId;

    @Column(name = "STATUS_NOME")
    private String statusNome;

    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;

}
