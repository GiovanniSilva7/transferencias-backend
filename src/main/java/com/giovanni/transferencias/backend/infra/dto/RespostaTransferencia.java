package com.giovanni.transferencias.backend.infra.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RespostaTransferencia {
    Long id;
    String contaOrigem;
    String contaDestino;
    BigDecimal valor;
    LocalDate dataTransferencia;
    OffsetDateTime dataAgendamento;
    BigDecimal taxaFixa;
    BigDecimal taxaPercentual;
    BigDecimal valorTaxaTotal;
    String status;
}
