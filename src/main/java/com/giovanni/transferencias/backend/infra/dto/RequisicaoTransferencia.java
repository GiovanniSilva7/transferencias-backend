package com.giovanni.transferencias.backend.infra.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class RequisicaoTransferencia {
    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Conta de origem deve ter 10 dígitos")
    private String contaOrigem;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Conta de destino deve ter 10 dígitos")
    private String contaDestino;

    @NotNull @DecimalMin("0.01")
    private BigDecimal valor;

    @NotNull
    private LocalDate dataTransferencia; 
}
