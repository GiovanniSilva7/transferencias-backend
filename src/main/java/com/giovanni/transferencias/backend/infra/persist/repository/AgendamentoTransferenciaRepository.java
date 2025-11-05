package com.giovanni.transferencias.backend.infra.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giovanni.transferencias.backend.entity.AgendamentoTransferenciaEntity;

public interface AgendamentoTransferenciaRepository extends  JpaRepository<AgendamentoTransferenciaEntity, Long>{
    
}
