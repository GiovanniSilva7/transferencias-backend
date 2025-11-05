package com.giovanni.transferencias.backend.service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.giovanni.transferencias.backend.exception.NegocioException;
import com.giovanni.transferencias.backend.infra.dto.RequisicaoTransferencia;
import com.giovanni.transferencias.backend.infra.dto.RespostaTransferencia;
import com.giovanni.transferencias.backend.infra.persist.repository.AgendamentoTransferenciaRepository;
import com.giovanni.transferencias.backend.mapper.TransferenciaMapper;
import com.giovanni.transferencias.backend.model.AgendamentoTransferencia;
import com.giovanni.transferencias.backend.entity.AgendamentoTransferenciaEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final AgendamentoTransferenciaRepository repository;
    private final TaxaCalculator taxaCalculator;

    public RespostaTransferencia agendar(RequisicaoTransferencia req){
        int dias = (int) ChronoUnit.DAYS.between(LocalDate.now(), req.getDataTransferencia());
        if(dias < 0) throw new NegocioException("Data da transferência não pode ser no passado");

        var taxa = taxaCalculator.calcular(dias, req.getValor())
                .orElseThrow(() -> new NegocioException("Sem taxa aplicável para a data informada"));

        AgendamentoTransferenciaEntity entity = new AgendamentoTransferenciaEntity();
        entity.setContaOrigem(req.getContaOrigem());
        entity.setContaDestino(req.getContaDestino());
        entity.setValor(req.getValor());
        entity.setDataTransferencia(req.getDataTransferencia());
        entity.setDataAgendamento(OffsetDateTime.now());
        entity.setTaxaFixa(taxa.fixa);
        entity.setTaxaPercentual(taxa.percentual);
        entity.setValorTaxaTotal(taxa.total);
        entity.setStatus("SCHEDULED");

        entity = repository.save(entity);
        return TransferenciaMapper.toResponse(entity); 
    }

    public Page<RespostaTransferencia> listar(Pageable pageable){
        return repository.findAll(pageable).map(TransferenciaMapper::toResponse); 
    }
}
