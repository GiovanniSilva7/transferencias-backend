package com.giovanni.transferencias.backend.infra.persist.adapter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.giovanni.transferencias.backend.entity.AgendamentoTransferenciaEntity;
import com.giovanni.transferencias.backend.infra.persist.port.PortaRepositorioTransferencia;
import com.giovanni.transferencias.backend.infra.persist.repository.AgendamentoTransferenciaRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AdaptadorRepositorioTransferencia implements PortaRepositorioTransferencia {
private final AgendamentoTransferenciaRepository repo;
public AgendamentoTransferenciaEntity salvar(AgendamentoTransferenciaEntity entity){ return repo.save(entity); }
public Page<AgendamentoTransferenciaEntity> listar(Pageable pageable){ return repo.findAll(pageable); }
}