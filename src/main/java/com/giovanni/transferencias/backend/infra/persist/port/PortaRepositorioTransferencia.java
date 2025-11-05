package com.giovanni.transferencias.backend.infra.persist.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.giovanni.transferencias.backend.entity.AgendamentoTransferenciaEntity;

public interface PortaRepositorioTransferencia {
AgendamentoTransferenciaEntity salvar(AgendamentoTransferenciaEntity entity);
Page<AgendamentoTransferenciaEntity> listar(Pageable pageable);
}