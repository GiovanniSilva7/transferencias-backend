package com.giovanni.transferencias.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoTransferencia {
    Long id;
    String contaOrigem;
    String contaDestino;
    BigDecimal valor;
    LocalDate dataTransferencia;
    OffsetDateTime dataAgendamento;
    Taxa taxa;
    BigDecimal taxaFixa;
    BigDecimal taxaPercentual;
    BigDecimal valorTaxaTotal;
    String status;
}
