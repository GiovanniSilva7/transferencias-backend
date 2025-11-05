package com.giovanni.transferencias.backend.mapper;

import com.giovanni.transferencias.backend.entity.AgendamentoTransferenciaEntity;
import com.giovanni.transferencias.backend.infra.dto.RespostaTransferencia;
import com.giovanni.transferencias.backend.model.AgendamentoTransferencia;

public class TransferenciaMapper {
    public static RespostaTransferencia toResponse(AgendamentoTransferencia e) {
        return RespostaTransferencia.builder()
                .id(e.getId())
                .contaOrigem(e.getContaOrigem())
                .contaDestino(e.getContaDestino())
                .valor(e.getValor())
                .dataTransferencia(e.getDataTransferencia())
                .dataAgendamento(e.getDataAgendamento())
                .taxaFixa(e.getTaxaFixa())
                .taxaPercentual(e.getTaxaPercentual())
                .valorTaxaTotal(e.getValorTaxaTotal())
                .status(e.getStatus())
                .build();
    }

    public static RespostaTransferencia toResponse(AgendamentoTransferenciaEntity e) {
        return RespostaTransferencia.builder()
                .id(e.getId())
                .contaOrigem(e.getContaOrigem())
                .contaDestino(e.getContaDestino())
                .valor(e.getValor())
                .dataTransferencia(e.getDataTransferencia())
                .dataAgendamento(e.getDataAgendamento())
                .taxaFixa(e.getTaxaFixa())
                .taxaPercentual(e.getTaxaPercentual())
                .valorTaxaTotal(e.getValorTaxaTotal())
                .status(e.getStatus())
                .build();
    }
}
