package com.giovanni.transferencias.backend.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="transferencias")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="conta_origem", nullable=false, length=10)
    private String contaOrigem;

    @Column(name="conta_destino", nullable=false, length=10)
    private String contaDestino;

    @Column(name = "valor_transferencia", nullable = false, precision = 15, scale = 2)
    private BigDecimal valorTransferencia;

    @Column(name = "taxa", nullable = false, precision = 15, scale = 2)
    private BigDecimal taxa;

    @Column(name = "data_transferencia", nullable = false)
    private LocalDate dataTransferencia;

    @Column(name = "data_agendamento", nullable = false)
    private LocalDate dataAgendamento;
    
}
