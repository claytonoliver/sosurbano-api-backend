package com.br.sosurbano.sosurbano.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SOU_GENERO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GeneroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO", allocationSize = 1)
    @Column(name = "GENERO_ID")
    private Integer id;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;
}
