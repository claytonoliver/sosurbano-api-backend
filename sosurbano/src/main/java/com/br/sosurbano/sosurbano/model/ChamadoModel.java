package com.br.sosurbano.sosurbano.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SOU_CHAMADO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ChamadoModel {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CHAMADOS"
    )
    @SequenceGenerator(
            name = "SEQ_CHAMADOS",
            sequenceName = "SEQ_CHAMADOS",
            allocationSize = 1
    )
    @Column(name = "CHAMADO_ID")
    private Integer chamadoId;

    @Column(name = "USUARIO_ID")
    private Integer usuarioId;

    @Column(name = "STATUS_ID", insertable = false, updatable = false)
    private Integer statusId;

    @Column(name = "DATA_CHAMADO")
    private LocalDateTime dataChamado;

    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID")
    private StatusChamadoModel statusChamado;
}
