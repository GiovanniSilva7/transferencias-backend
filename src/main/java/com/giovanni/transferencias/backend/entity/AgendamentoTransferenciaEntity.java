package com.giovanni.transferencias.backend.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transfer_schedule")
@Data
@NoArgsConstructor
public class AgendamentoTransferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String contaOrigem;

    @Column(length = 10, nullable = false)
    private String contaDestino;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate dataTransferencia;

    @Column(nullable = false)
    private OffsetDateTime dataAgendamento;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal taxaFixa;

    @Column(nullable = false, precision = 5, scale = 4)
    private BigDecimal taxaPercentual;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valorTaxaTotal;

    @Column(nullable = false, length = 20)
    private String status;
}
