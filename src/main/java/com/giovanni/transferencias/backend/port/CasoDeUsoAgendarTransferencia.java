package com.giovanni.transferencias.backend.port;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.giovanni.transferencias.backend.model.AgendamentoTransferencia;

public interface CasoDeUsoAgendarTransferencia {
    AgendamentoTransferencia agendar(String contaOrigem, String contaDestino, BigDecimal valor,
            LocalDate dataTransferencia);
}
